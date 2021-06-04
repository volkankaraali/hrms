package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CvExperience;
import kodlamaio.hrms.entities.concretes.CvImage;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface CvImageService {

    Result add(CvImage cvImage, MultipartFile file);

    DataResult<List<CvImage>> getAll();

    DataResult<CvImage> getById(int id);

    DataResult<List<CvImage>> getByCandidateId(int id);

}
