package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.business.abstracts.CvEducationService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CvAbility;
import kodlamaio.hrms.entities.concretes.CvEducation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cvEducations")
public class CvEducationsController {

    private CvEducationService cvEducationService;

    @Autowired
    public CvEducationsController(CvEducationService cvEducationService) {
        this.cvEducationService = cvEducationService;
    }

    @PostMapping("/add")
    public Result add(@RequestBody CvEducation cvEducation){
        return this.cvEducationService.add(cvEducation);
    }

    @GetMapping("/getall")
    public DataResult<List<CvEducation>> getAll(){
        return this.cvEducationService.getAll();
    }

    @GetMapping("/getbyid")
    public DataResult<CvEducation> getById(@RequestParam int id){
        return this.cvEducationService.getById(id);
    }

    @GetMapping("/getByCandidateId")
    public DataResult<List<CvEducation>> getByCandidateId(@RequestParam int id){
        return this.cvEducationService.getByCandidateId(id);
    }
}
