package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.business.abstracts.JobAdvertService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobAdvert;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobadverts")
public class JobAdvertsController {

    private JobAdvertService jobAdvertService;

    public JobAdvertsController(JobAdvertService jobAdvertService) {
        this.jobAdvertService = jobAdvertService;
    }

    @GetMapping("/getall")
    public DataResult<List<JobAdvert>> getAll(){
        return this.jobAdvertService.getAll();
    }

    @PostMapping("/add")
    public Result add(JobAdvert jobAdvert){
        return this.jobAdvertService.add(jobAdvert);
    }

    @GetMapping("/getAllActive")
    public DataResult<List<JobAdvert>> getAllActive(){
        return this.jobAdvertService.getAllActive();
    }

    @GetMapping("/getAllActiveByCreatedDate")
    public DataResult<List<JobAdvert>> getAllActiveByCreatedDate(){
        return this.jobAdvertService.getAllActiveByCreatedDate();
    }

    @GetMapping("/getAllActiveByEmployer")
    public DataResult<List<JobAdvert>> getAllActiveByEmployer(int employerId){
        return this.jobAdvertService.getAllActiveByEmployer(employerId);
    }

    @GetMapping("/getJobAdvertById")
    public DataResult<JobAdvert> getJobAdvertById(int jobAdvertId){
        return this.jobAdvertService.getJobAdvertById(jobAdvertId);
    }

    @PostMapping("changeJobAdvertStatus")
    public Result changeJobAdvertStatus(int jobAdvertId){
        return this.jobAdvertService.changeJobAdvertStatusToClose(jobAdvertId);
    }
}
