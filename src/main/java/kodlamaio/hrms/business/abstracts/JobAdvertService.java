package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobAdvert;
import kodlamaio.hrms.entities.dtos.ActiveJobAdvertDto;

import java.util.List;

public interface JobAdvertService {

    DataResult<List<JobAdvert>> getAll();

    DataResult<List<JobAdvert>> getAllActive();

    DataResult<List<ActiveJobAdvertDto>> getAllActiveByCreatedDate();

    DataResult<List<ActiveJobAdvertDto>> getAllActiveByEmployer(int employerId);

    DataResult<JobAdvert> getJobAdvertById(int jobAdvertId);

    Result add(JobAdvert jobAdvert);

    Result changeJobAdvertStatus(int jobAdvertId);

    DataResult<List<ActiveJobAdvertDto>> getActiveJobAdvert();
}
