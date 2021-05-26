package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.business.abstracts.VerificationCodeService;
import kodlamaio.hrms.core.adapter.VerificationService;
import kodlamaio.hrms.core.utilities.results.*;
import kodlamaio.hrms.core.validation.ValidationService;
import kodlamaio.hrms.dataAccess.abstracts.CandidateDao;
import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.concretes.VerificationCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class CandidateManager implements CandidateService {

    private CandidateDao candidateDao;
    private VerificationService verificationService;
    private ValidationService validationService;
    private VerificationCodeService verificationCodeService;

    @Autowired
    public CandidateManager(CandidateDao candidateDao, VerificationService verificationService,ValidationService validationService,VerificationCodeService verificationCodeService){
        this.candidateDao=candidateDao;
        this.verificationService = verificationService;
        this.validationService=validationService;
        this.verificationCodeService=verificationCodeService;
    }
    @Override
    public DataResult<List<Candidate>> getAll() {
        return new SuccessDataResult<List<Candidate>>(this.candidateDao.findAll(),"is arayanlar listelendi.");
    }

    @Override
    public Result add(Candidate candidate) {

        if (!emptyInfoCheck(candidate)){
            return new ErrorResult("bilgileriniz bos");
        }
        if (!mernisValidate(Long.parseLong(candidate.getIdentityNumber()),candidate.getFirstName(),candidate.getLastName(),candidate.getBirthDate().getYear())){
            return new ErrorResult("mernis dogrulanamasi basarisiz.");
        }

        if(!emailAndIdentityNumberCheck(candidate.getEmail(),candidate.getIdentityNumber())){
            return new ErrorResult("email ve tcno daha önce kullanildi.");
        }


        this.candidateDao.save(candidate);
        String generetedCode_= this.validationService.sendCode(candidate.getEmail()); //mail gönderir ve dogrulama kodunu geri doner
        verificationCodeSave(candidate.getId(),generetedCode_); //verificationcode tablosuna candidate id ve kod ile kaydeder
        return new SuccessResult("Kayit basarili.");


    }

    private boolean emailAndIdentityNumberCheck(String email, String identityNo){
        for (var dataOnDb: candidateDao.findAll()){
            if (email.equals(dataOnDb.getEmail()) && identityNo.equals(dataOnDb.getIdentityNumber())){
                return false;
            }
        }
        return true;
    }

    private boolean mernisValidate(Long identityNo, String firstName, String lastName, int birthYear){
        return verificationService.validateByMernis(identityNo, firstName, lastName, birthYear);

    }
    private boolean emptyInfoCheck(Candidate candidate){
        return candidate.getFirstName() != null && candidate.getLastName() != null && candidate.getEmail() != null && candidate.getIdentityNumber() != null
                && candidate.getPassword() != null && candidate.getBirthDate() != null;
    }


    private void verificationCodeSave(int id,String generetedCode){

        VerificationCode verificationCode=new VerificationCode(id,generetedCode,false, LocalDate.now());
        this.verificationCodeService.add(verificationCode);
    }




}
