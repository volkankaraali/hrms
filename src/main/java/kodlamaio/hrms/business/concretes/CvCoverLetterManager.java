package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.CvCoverLetterService;
import kodlamaio.hrms.core.utilities.results.*;
import kodlamaio.hrms.dataAccess.abstracts.CvCoverLetterDao;
import kodlamaio.hrms.entities.concretes.CvAbility;
import kodlamaio.hrms.entities.concretes.CvCoverLetter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CvCoverLetterManager implements CvCoverLetterService {

    private CvCoverLetterDao cvCoverLetterDao;

    @Autowired
    public CvCoverLetterManager(CvCoverLetterDao cvCoverLetterDao) {
        this.cvCoverLetterDao = cvCoverLetterDao;
    }

    @Override
    public Result add(CvCoverLetter cvCoverLetter) {
        this.cvCoverLetterDao.save(cvCoverLetter);
        return new SuccessResult("on yazi eklendi.");
    }

    @Override
    public DataResult<List<CvCoverLetter>> getAll() {
        return new SuccessDataResult<List<CvCoverLetter>>(this.cvCoverLetterDao.findAll(),"listeleme basarili");

    }

    @Override
    public DataResult<CvCoverLetter> getById(int id) {
        CvCoverLetter cvCoverLetter=this.cvCoverLetterDao.getById(id);
        if (cvCoverLetter == null){
            return new ErrorDataResult<>("boyle bir veri yok.");
        }
        return new SuccessDataResult<CvCoverLetter>(cvCoverLetter);
    }

    @Override
    public DataResult<List<CvCoverLetter>> getByCandidateId(int id) {
        return new SuccessDataResult<List<CvCoverLetter>>(this.cvCoverLetterDao.getByCandidate_id(id));

    }
}
