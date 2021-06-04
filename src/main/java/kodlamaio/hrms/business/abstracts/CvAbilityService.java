package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CvAbility;

import java.util.List;

public interface CvAbilityService {

    Result add(CvAbility cvAbility);

    DataResult<List<CvAbility>> getAll();

    DataResult<CvAbility> getById(int id);

    DataResult<List<CvAbility>> getByCandidateId(int id);
 }
