package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CvLanguage;
import kodlamaio.hrms.entities.concretes.CvSocialMedia;

import java.util.List;

public interface CvSocialMediaService {

    Result add(CvSocialMedia cvSocialMedia);

    DataResult<List<CvSocialMedia>> getAll();

    DataResult<CvSocialMedia> getById(int id);

    DataResult<List<CvSocialMedia>> getByCandidateId(int id);
}
