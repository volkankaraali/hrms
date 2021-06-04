package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CvEduGraduateType;

import java.util.List;

public interface CvEduGraduateTypeService {

    Result add(CvEduGraduateType cvEduGraduateType);
    DataResult<List<CvEduGraduateType>> getAll();
}
