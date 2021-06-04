package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.CvSocialMediaService;
import kodlamaio.hrms.core.utilities.results.*;
import kodlamaio.hrms.dataAccess.abstracts.CvSocialMediaDao;
import kodlamaio.hrms.entities.concretes.CvAbility;
import kodlamaio.hrms.entities.concretes.CvLanguage;
import kodlamaio.hrms.entities.concretes.CvSocialMedia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CvSocialMediaManager implements CvSocialMediaService {

    private CvSocialMediaDao cvSocialMediaDao;

    @Autowired
    public CvSocialMediaManager(CvSocialMediaDao cvSocialMediaDao) {
        this.cvSocialMediaDao = cvSocialMediaDao;
    }

    @Override
    public Result add(CvSocialMedia cvSocialMedia) {
        this.cvSocialMediaDao.save(cvSocialMedia);
        return new SuccessResult("sosyal medya eklendi.");
    }

    @Override
    public DataResult<List<CvSocialMedia>> getAll() {
        return new SuccessDataResult<List<CvSocialMedia>>(this.cvSocialMediaDao.findAll());
    }

    @Override
    public DataResult<CvSocialMedia> getById(int id) {
        CvSocialMedia cvSocialMedia=this.cvSocialMediaDao.getById(id);
        if (cvSocialMedia == null){
            return new ErrorDataResult<>("boyle bir veri yok.");
        }
        return new SuccessDataResult<CvSocialMedia>(cvSocialMedia);
    }

    @Override
    public DataResult<List<CvSocialMedia>> getByCandidateId(int id) {
        return new SuccessDataResult<List<CvSocialMedia>>(this.cvSocialMediaDao.getByCandidate_id(id));
    }
}
