package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.business.abstracts.VerificationCodeService;
import kodlamaio.hrms.core.utilities.results.*;
import kodlamaio.hrms.core.validation.ValidationService;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.entities.concretes.VerificationCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class EmployerManager implements EmployerService {

    private EmployerDao employerDao;
    private ValidationService validationService;
    private VerificationCodeService verificationCodeService;

    @Autowired
    public EmployerManager(EmployerDao employerDao,ValidationService validationService,VerificationCodeService verificationCodeService) {
        this.employerDao = employerDao;
        this.validationService=validationService;
        this.verificationCodeService=verificationCodeService;
    }

    @Override
    public DataResult<List<Employer>> getAll() {
        return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(),"is verenler listelendi");
    }

    @Override
    public Result add(Employer employer) {

        if(!emptyInfoCheck(employer)){
            return new ErrorResult("bos bilgi birakilamaz.");
        }

        if(!checkEmailAndDomain(employer.getEmail(),employer.getWebAddress())){
            return new ErrorResult("web adresi domain ile email uyusmuyor.");
        }

        if(!checkEmail(employer.getEmail())){
            return new ErrorResult("email daha once kullanildi.");
        }

        this.employerDao.save(employer);
        String generetedCode_= this.validationService.sendCode(employer.getEmail());
        verificationCodeSave(employer.getId(),generetedCode_);
        return new SuccessResult("is veren eklendi.");
    }



    private boolean checkEmail(String email){
        for (var dataOnDb: employerDao.findAll()){
            if (email.equals(dataOnDb.getEmail())){
                return false;
            }
        }
        return true;
    }
    private boolean checkEmailAndDomain(String email, String webAddress){
        //email regex
        String[] emailA=email.split("@",2);
        String domain=webAddress.substring(4,webAddress.length());

        return emailA[1].equals(domain);

    }
    private boolean emptyInfoCheck(Employer employer){
        return employer.getCompanyName() != null && employer.getWebAddress() != null && employer.getPhoneNumber() != null && employer.getEmail() != null
                && employer.getPassword() != null;
    }

    private void verificationCodeSave(int id,String generetedCode){

        VerificationCode verificationCode=new VerificationCode(id,generetedCode,false, LocalDate.now());
        this.verificationCodeService.add(verificationCode);
    }
}
