package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.CvEduGraduateTypeService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CvEduGraduateTypeDao;
import kodlamaio.hrms.entities.concretes.CvEduGraduateType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CvEduGraduateTypeManager implements CvEduGraduateTypeService {

    private CvEduGraduateTypeDao cvEduGraduateTypeDao;

    @Autowired
    public CvEduGraduateTypeManager(CvEduGraduateTypeDao cvEduGraduateTypeDao) {
        this.cvEduGraduateTypeDao = cvEduGraduateTypeDao;
    }

    @Override
    public Result add(CvEduGraduateType cvEduGraduateType) {
        this.cvEduGraduateTypeDao.save(cvEduGraduateType);
        return new SuccessResult("Egitim türü ekleme basarili");
    }

    @Override
    public DataResult<List<CvEduGraduateType>> getAll() {
        return new SuccessDataResult<List<CvEduGraduateType>>(this.cvEduGraduateTypeDao.findAll(),"listeleme basarili.");
    }
}
