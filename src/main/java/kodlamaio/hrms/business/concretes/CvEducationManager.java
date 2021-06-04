package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.CvEducationService;
import kodlamaio.hrms.core.utilities.results.*;
import kodlamaio.hrms.dataAccess.abstracts.CvEducationDao;
import kodlamaio.hrms.entities.concretes.CvEducation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CvEducationManager implements CvEducationService {

    private CvEducationDao cvEducationDao;

    @Autowired
    public CvEducationManager(CvEducationDao cvEducationDao) {
        this.cvEducationDao = cvEducationDao;
    }

    @Override
    public Result add(CvEducation cvEducation) {
        this.cvEducationDao.save(cvEducation);
        return new SuccessResult("egitim eklendi.");
    }

    @Override
    public DataResult<List<CvEducation>> getAll() {
        return new SuccessDataResult<List<CvEducation>>(this.cvEducationDao.findAll(),"listeleme basarili.");
    }

    @Override
    public DataResult<CvEducation> getById(int id) {
        CvEducation cvEducation=this.cvEducationDao.getById(id);
        if (cvEducation==null){
            return new ErrorDataResult<>("boyle bir veri yok.");
        }
        return new SuccessDataResult<CvEducation>(this.cvEducationDao.getById(id));
    }

    @Override
    public DataResult<List<CvEducation>> getByCandidateId(int id) {
        return new SuccessDataResult<List<CvEducation>>(this.cvEducationDao.getByCandidate_id(id));
    }
}
