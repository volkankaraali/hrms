package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.*;
import kodlamaio.hrms.core.adapter.VerificationService;
import kodlamaio.hrms.core.utilities.results.*;
import kodlamaio.hrms.core.validation.ValidationService;
import kodlamaio.hrms.dataAccess.abstracts.CandidateDao;
import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.concretes.CvCoverLetter;
import kodlamaio.hrms.entities.concretes.VerificationCode;
import kodlamaio.hrms.entities.dtos.CandidateCvDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class CandidateManager implements CandidateService {

    private CandidateDao candidateDao;
    private VerificationService verificationService;
    private ValidationService validationService;
    private VerificationCodeService verificationCodeService;

    //for cv
    private CvAbilityService cvAbilityService;
    private CvCoverLetterService cvCoverLetterService;
    private CvEducationService cvEducationService;
    private CvExperienceService cvExperienceService;
    private CvImageService cvImageService;
    private CvLanguageService cvLanguageService;
    private CvSocialMediaService cvSocialMediaService;

    @Autowired
    public CandidateManager(CandidateDao candidateDao, VerificationService verificationService, ValidationService validationService, VerificationCodeService verificationCodeService, CvAbilityService cvAbilityService, CvCoverLetterService cvCoverLetterService,CvEducationService cvEducationService, CvExperienceService cvExperienceService, CvImageService cvImageService, CvLanguageService cvLanguageService, CvSocialMediaService cvSocialMediaService) {
        this.candidateDao = candidateDao;
        this.verificationService = verificationService;
        this.validationService = validationService;
        this.verificationCodeService = verificationCodeService;
        this.cvAbilityService = cvAbilityService;
        this.cvCoverLetterService=cvCoverLetterService;
        this.cvEducationService = cvEducationService;
        this.cvExperienceService = cvExperienceService;
        this.cvImageService = cvImageService;
        this.cvLanguageService = cvLanguageService;
        this.cvSocialMediaService = cvSocialMediaService;
    }

    @Override
    public DataResult<List<Candidate>> getAll() {
        if (this.candidateDao.getNoDeletedCandidate().isEmpty()){
            return new ErrorDataResult<>("İs arayan bulunmamaktadir.");
        }
        return new SuccessDataResult<List<Candidate>>(this.candidateDao.getNoDeletedCandidate(),"is arayanlar listelendi.");
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

    @Override
    public Result passiveDelete(int candidateId) {
        Candidate candidate=this.candidateDao.findById(candidateId);
        candidate.setDeleted(true);
        this.candidateDao.save(candidate);
        return new SuccessResult("is veren silindi.");

    }

    @Override
    public DataResult<Candidate> getById(int candidateId) {
        return new SuccessDataResult<Candidate>(this.candidateDao.findById(candidateId));
    }

    @Override
    public DataResult<CandidateCvDto> getCandidateCvById(int id) {
       CandidateCvDto cv= new CandidateCvDto();
       cv.setCandidate(this.candidateDao.findById(id));
       cv.setCvAbilities(this.cvAbilityService.getByCandidateId(id).getData());
       cv.setCvCoverLetters(this.cvCoverLetterService.getByCandidateId(id).getData());
       cv.setCvEducations(this.cvEducationService.getByCandidateId(id).getData());
       cv.setCvExperiences(this.cvExperienceService.getByCandidateId(id).getData());
       cv.setCvImage(this.cvImageService.getByCandidateId(id).getData());
       cv.setCvLanguages(this.cvLanguageService.getByCandidateId(id).getData());
       cv.setCvSocialMedias(this.cvSocialMediaService.getByCandidateId(id).getData());
       return new SuccessDataResult<CandidateCvDto>(cv);
    }

    //restrictions of save

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
