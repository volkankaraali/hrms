package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CvExperience;
import kodlamaio.hrms.entities.concretes.CvLanguage;

import java.util.List;

public interface CvLanguageService {

    Result add(CvLanguage cvLanguage);

    DataResult<List<CvLanguage>> getAll();

    DataResult<CvLanguage> getById(int id);

    DataResult<List<CvLanguage>> getByCandidateId(int id);
}
