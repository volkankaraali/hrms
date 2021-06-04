package kodlamaio.hrms.api.controllers;


import kodlamaio.hrms.business.abstracts.CvSocialMediaService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CvLanguage;
import kodlamaio.hrms.entities.concretes.CvSocialMedia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cvSocialMedias")
public class CvSocialMediasController {

    private CvSocialMediaService cvSocialMediaService;

    @Autowired
    public CvSocialMediasController(CvSocialMediaService cvSocialMediaService) {
        this.cvSocialMediaService = cvSocialMediaService;
    }

    @PostMapping("/add")
    public Result add(@RequestBody CvSocialMedia cvSocialMedia){
        return this.cvSocialMediaService.add(cvSocialMedia);
    }

    @GetMapping("/getall")
    public DataResult<List<CvSocialMedia>> getAll(){
        return this.cvSocialMediaService.getAll();
    }

    @GetMapping("/getbyid")
    public DataResult<CvSocialMedia> getById(@RequestParam int id){
        return this.cvSocialMediaService.getById(id);
    }

    @GetMapping("/getByCandidateId")
    public DataResult<List<CvSocialMedia>> getByCandidateId(@RequestParam int id){
        return this.cvSocialMediaService.getByCandidateId(id);
    }
}
