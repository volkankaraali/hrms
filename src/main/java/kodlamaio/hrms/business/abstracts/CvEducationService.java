package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CvAbility;
import kodlamaio.hrms.entities.concretes.CvEducation;

import java.util.List;

public interface CvEducationService {

    Result add(CvEducation cvEducation);

    DataResult<List<CvEducation>> getAll();

    DataResult<CvEducation> getById(int id);

    DataResult<List<CvEducation>> getByCandidateId(int id);
}
