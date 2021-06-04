package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.business.abstracts.CvExperienceService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CvEducation;
import kodlamaio.hrms.entities.concretes.CvExperience;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cvJobExperiences")
public class CvExperiencesController {

    private CvExperienceService cvExperienceService;

    @Autowired
    public CvExperiencesController(CvExperienceService cvExperienceService) {
        this.cvExperienceService = cvExperienceService;
    }


    @PostMapping("/add")
    public Result add(@RequestBody CvExperience cvExperience){
        return this.cvExperienceService.add(cvExperience);
    }

    @GetMapping("/getall")
    public DataResult<List<CvExperience>> getAll(){
        return this.cvExperienceService.getAll();
    }

    @GetMapping("/getbyid")
    public DataResult<CvExperience> getById(@RequestParam int id){
        return this.cvExperienceService.getById(id);
    }

    @GetMapping("/getByCandidateId")
    public DataResult<List<CvExperience>> getByCandidateId(@RequestParam int id){
        return this.cvExperienceService.getByCandidateId(id);
    }
}
