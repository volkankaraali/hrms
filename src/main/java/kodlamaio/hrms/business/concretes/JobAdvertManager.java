package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.JobAdvertService;
import kodlamaio.hrms.core.utilities.results.*;
import kodlamaio.hrms.dataAccess.abstracts.JobAdvertDao;

import kodlamaio.hrms.entities.concretes.JobAdvert;
import kodlamaio.hrms.entities.dtos.ActiveJobAdvertDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobAdvertManager implements JobAdvertService {

    private JobAdvertDao jobAdvertDao;

    @Autowired
    public JobAdvertManager(JobAdvertDao jobAdvertDao) {
        this.jobAdvertDao = jobAdvertDao;
    }

    @Override
    public DataResult<List<JobAdvert>> getAll() {
        if (this.jobAdvertDao.findAll().isEmpty()){
            return new ErrorDataResult<List<JobAdvert>>("is ilani bulunamamaktadir.");
        }
        return new SuccessDataResult<List<JobAdvert>>(this.jobAdvertDao.findAll(),"listeleme basarili");
    }

    @Override
    public Result add(JobAdvert jobAdvert) {
        this.jobAdvertDao.save(jobAdvert);
        return new SuccessResult("is ilani eklendi");
    }

    @Override
    public Result changeJobAdvertStatus(int jobAdvertId) {
        JobAdvert jobAdvert=getJobAdvertById(jobAdvertId).getData();
        if (jobAdvert.isActive()==true){
            jobAdvert.setActive(false);
            this.jobAdvertDao.save(jobAdvert);
            return new SuccessResult("is ilani kapatildi.");
        }

        jobAdvert.setActive(true);
        this.jobAdvertDao.save(jobAdvert);
        return new SuccessResult("İs ilani acildi.");

    }

    @Override
    public DataResult<List<ActiveJobAdvertDto>> getActiveJobAdvert() {
        return new SuccessDataResult<List<ActiveJobAdvertDto>>(this.jobAdvertDao.getActiveJobAdvert());
    }

    @Override
    public DataResult<List<JobAdvert>> getAllActive() {
        if (this.jobAdvertDao.getAllActive().isEmpty()){
            return new ErrorDataResult<List<JobAdvert>>("Aktif is ilani bulunamamaktadir.");
        }
        return new SuccessDataResult<List<JobAdvert>>(this.jobAdvertDao.getAllActive(),"listelendi.");
    }

    @Override
    public DataResult<List<ActiveJobAdvertDto>> getAllActiveByCreatedDate() {
        if (this.jobAdvertDao.getAllActive().isEmpty()){
            return new ErrorDataResult<List<ActiveJobAdvertDto>>("Aktif is ilani bulunamamaktadir.");
        }
        return new SuccessDataResult<List<ActiveJobAdvertDto>>(this.jobAdvertDao.getAllActiveByCreatedDate(),"listeledi.");
    }

    @Override
    public DataResult<List<ActiveJobAdvertDto>> getAllActiveByEmployer(int employerId) {

        if (this.jobAdvertDao.getAllActiveByEmployer(employerId).isEmpty()){
            return new ErrorDataResult<List<ActiveJobAdvertDto>>("Bu is verene göre is kaydi bulunmamaktadir");
        }
        return new SuccessDataResult<List<ActiveJobAdvertDto>>(this.jobAdvertDao.getAllActiveByEmployer(employerId));
    }

    @Override
    public DataResult<JobAdvert> getJobAdvertById(int jobAdvertId) {
        if (this.jobAdvertDao.getJobAdvertById(jobAdvertId)==null){
            return new ErrorDataResult<JobAdvert>("Is ilani bulunamadi.");
        }
        return new SuccessDataResult<JobAdvert>(this.jobAdvertDao.getJobAdvertById(jobAdvertId));
    }

}
