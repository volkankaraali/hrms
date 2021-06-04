package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CvAbility;
import kodlamaio.hrms.entities.concretes.CvCoverLetter;

import java.util.List;

public interface CvCoverLetterService {

    Result add(CvCoverLetter cvCoverLetter);

    DataResult<List<CvCoverLetter>> getAll();

    DataResult<CvCoverLetter> getById(int id);

    DataResult<List<CvCoverLetter>> getByCandidateId(int id);
}
