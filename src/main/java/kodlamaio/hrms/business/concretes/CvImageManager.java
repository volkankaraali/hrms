package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.CvImageService;
import kodlamaio.hrms.core.utilities.imageUpload.CloudinaryService;
import kodlamaio.hrms.core.utilities.results.*;
import kodlamaio.hrms.dataAccess.abstracts.CvImageDao;
import kodlamaio.hrms.entities.concretes.CvImage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@Service
public class CvImageManager implements CvImageService {

    private CvImageDao cvImageDao;
    private CloudinaryService cloudinaryService;

    @Autowired
    public CvImageManager(CvImageDao cvImageDao,CloudinaryService cloudinaryService) {
        this.cvImageDao = cvImageDao;
        this.cloudinaryService=cloudinaryService;
    }

    @Override
    public Result add(CvImage cvImage, MultipartFile file) {
        Map<String, String> uploader = (Map<String, String>) cloudinaryService.save(file).getData();
        String imageUrl= uploader.get("url");
        cvImage.setUrl(imageUrl);
        this.cvImageDao.save(cvImage);
        return new SuccessResult("fotograf eklendi.");
    }

    @Override
    public DataResult<List<CvImage>> getAll() {
        return new SuccessDataResult<List<CvImage>>(this.cvImageDao.findAll(),"listeleme basarili.");
    }

    @Override
    public DataResult<CvImage> getById(int id) {
        CvImage cvImage=this.cvImageDao.getById(id);
        if (cvImage==null){
            return new ErrorDataResult<>("boyle bir veri yok.");
        }
        return new SuccessDataResult<CvImage>(this.cvImageDao.getById(id));
    }

    @Override
    public DataResult<List<CvImage>> getByCandidateId(int id) {
        return new SuccessDataResult<List<CvImage>>(this.cvImageDao.getByCandidate_id(id));
    }
}
