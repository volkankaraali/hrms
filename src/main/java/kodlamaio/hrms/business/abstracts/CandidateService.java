package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.dtos.CandidateCvDto;

import java.util.List;

public interface CandidateService {

    DataResult<List<Candidate>> getAll();

    Result add(Candidate candidate);

    Result passiveDelete(int candidateId);

    DataResult<Candidate> getById(int candidateId);

    DataResult<CandidateCvDto> getCandidateCvById(int id);

}
