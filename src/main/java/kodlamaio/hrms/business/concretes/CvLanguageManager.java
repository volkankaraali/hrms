package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.CvLanguageService;
import kodlamaio.hrms.core.utilities.results.*;
import kodlamaio.hrms.dataAccess.abstracts.CvLanguageDao;
import kodlamaio.hrms.entities.concretes.CvAbility;
import kodlamaio.hrms.entities.concretes.CvExperience;
import kodlamaio.hrms.entities.concretes.CvLanguage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CvLanguageManager implements CvLanguageService {

   private CvLanguageDao cvLanguageDao;

   @Autowired
   public CvLanguageManager(CvLanguageDao cvLanguageDao) {
        this.cvLanguageDao = cvLanguageDao;
   }

    @Override
    public Result add(CvLanguage cvLanguage) {
       this.cvLanguageDao.save(cvLanguage);
       return new SuccessResult("yabanci dil ekleme basarili.");
    }

    @Override
    public DataResult<List<CvLanguage>> getAll() {
        return new SuccessDataResult<List<CvLanguage>>(this.cvLanguageDao.findAll(),"listeleme basarili");
    }

    @Override
    public DataResult<CvLanguage> getById(int id) {
        CvLanguage cvLanguage=this.cvLanguageDao.getById(id);
        if (cvLanguage == null){
            return new ErrorDataResult<>("boyle bir veri yok.");
        }
        return new SuccessDataResult<CvLanguage>(cvLanguage);
    }

    @Override
    public DataResult<List<CvLanguage>> getByCandidateId(int id) {
        return new SuccessDataResult<List<CvLanguage>>(this.cvLanguageDao.getByCandidate_id(id));
    }
}
