package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.VerificationCodeService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.VerificationCodeDao;
import kodlamaio.hrms.entities.concretes.VerificationCode;
import org.springframework.stereotype.Service;

@Service
public class VerificationCodeManager  implements VerificationCodeService {

    private VerificationCodeDao verificationCodeDao;

    public VerificationCodeManager(VerificationCodeDao verificationCodeDao) {
        this.verificationCodeDao = verificationCodeDao;
    }

    @Override
    public Result add(VerificationCode code) {
        this.verificationCodeDao.save(code);
        return new SuccessResult("Dogrulama kodu olusturuldu.");
    }
}
