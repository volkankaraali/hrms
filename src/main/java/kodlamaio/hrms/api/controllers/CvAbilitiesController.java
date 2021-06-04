package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.business.abstracts.CvAbilityService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CvAbility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cvAbilities")
public class CvAbilitiesController {

    private CvAbilityService cvAbilityService;

    @Autowired
    public CvAbilitiesController(CvAbilityService cvAbilityService) {
        this.cvAbilityService = cvAbilityService;
    }

    @GetMapping("/getall")
    public DataResult<List<CvAbility>> getAll(){
        return this.cvAbilityService.getAll();
    }

    @PostMapping("/add")
    public Result add(@RequestBody CvAbility cvAbility){
        return this.cvAbilityService.add(cvAbility);
    }

    @GetMapping("/getById")
    public DataResult<CvAbility> getById(@RequestParam int id){
        return this.cvAbilityService.getById(id);
    }

    @GetMapping("/getByCandidateId")
    public DataResult<List<CvAbility>> getByCandidateId(@RequestParam int id){
        return this.cvAbilityService.getByCandidateId(id);
    }
}
