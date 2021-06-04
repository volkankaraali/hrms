package kodlamaio.hrms.core.utilities.imageUpload;

import kodlamaio.hrms.core.utilities.results.DataResult;
import org.springframework.web.multipart.MultipartFile;

public interface CloudinaryService {

    DataResult<?> save(MultipartFile file);
}
