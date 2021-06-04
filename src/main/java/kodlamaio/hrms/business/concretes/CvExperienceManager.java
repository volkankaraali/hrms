package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.CvExperienceService;
import kodlamaio.hrms.core.utilities.results.*;
import kodlamaio.hrms.dataAccess.abstracts.CvExperienceDao;
import kodlamaio.hrms.entities.concretes.CvAbility;
import kodlamaio.hrms.entities.concretes.CvEducation;
import kodlamaio.hrms.entities.concretes.CvExperience;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CvExperienceManager implements CvExperienceService {

    private CvExperienceDao cvExperienceDao;

    @Autowired
    public CvExperienceManager(CvExperienceDao cvExperienceDao) {
        this.cvExperienceDao = cvExperienceDao;
    }

    @Override
    public Result add(CvExperience cvExperience) {
        this.cvExperienceDao.save(cvExperience);
        return new SuccessResult("is deneyimi ekleme basarili.");
    }

    @Override
    public DataResult<List<CvExperience>> getAll() {
        return new SuccessDataResult<List<CvExperience>>(this.cvExperienceDao.findAll(),"listeleme basarili");
    }

    @Override
    public DataResult<CvExperience> getById(int id) {
        CvExperience cvExperience=this.cvExperienceDao.getById(id);
        if (cvExperience == null){
            return new ErrorDataResult<>("boyle bir veri yok.");
        }
        return new SuccessDataResult<CvExperience>(cvExperience);
    }

    @Override
    public DataResult<List<CvExperience>> getByCandidateId(int id) {
        return new SuccessDataResult<List<CvExperience>>(this.cvExperienceDao.getByCandidate_id(id));
    }
}
