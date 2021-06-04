package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CvEducation;
import kodlamaio.hrms.entities.concretes.CvExperience;

import java.util.List;

public interface CvExperienceService {

    Result add(CvExperience cvExperience);

    DataResult<List<CvExperience>> getAll();

    DataResult<CvExperience> getById(int id);

    DataResult<List<CvExperience>> getByCandidateId(int id);
}
