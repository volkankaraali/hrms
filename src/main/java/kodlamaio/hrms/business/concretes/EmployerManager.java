package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.business.abstracts.VerificationCodeService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
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

        return new SuccessResult("is verenler eklendi.");
    }

    private void verificationCodeSave(int id,String generetedCode){

        VerificationCode verificationCode=new VerificationCode(id,generetedCode,false, LocalDate.now());
        this.verificationCodeService.add(verificationCode);
    }
}
