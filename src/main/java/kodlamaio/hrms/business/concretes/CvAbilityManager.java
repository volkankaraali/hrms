package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.CvAbilityService;
import kodlamaio.hrms.core.utilities.results.*;
import kodlamaio.hrms.dataAccess.abstracts.CvAbilityDao;
import kodlamaio.hrms.entities.concretes.CvAbility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CvAbilityManager implements CvAbilityService {

    private CvAbilityDao cvAbilityDao;

    @Autowired
    public CvAbilityManager(CvAbilityDao cvAbilityDao) {
        this.cvAbilityDao = cvAbilityDao;
    }

    @Override
    public Result add(CvAbility cvAbility) {
        this.cvAbilityDao.save(cvAbility);
        return new SuccessResult("Yetenek eklendi.");
    }

    @Override
    public DataResult<List<CvAbility>> getAll() {
        return new SuccessDataResult<List<CvAbility>>(this.cvAbilityDao.findAll(),"listeleme basarili");
    }

    @Override
    public DataResult<CvAbility> getById(int id) {
        CvAbility cvAbility=this.cvAbilityDao.getById(id);
        if (cvAbility == null){
            return new ErrorDataResult<>("boyle bir veri yok.");
        }
        return new SuccessDataResult<CvAbility>(cvAbility);
    }

    @Override
    public DataResult<List<CvAbility>> getByCandidateId(int id) {
        return new SuccessDataResult<List<CvAbility>>(this.cvAbilityDao.getByCandidate_id(id));
    }
}
