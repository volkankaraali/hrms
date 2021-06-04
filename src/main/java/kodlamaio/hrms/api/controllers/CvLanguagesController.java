package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.business.abstracts.CvLanguageService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CvExperience;
import kodlamaio.hrms.entities.concretes.CvLanguage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cvLanguages")
public class CvLanguagesController {

    private CvLanguageService cvLanguageService;

    @Autowired
    public CvLanguagesController(CvLanguageService cvLanguageService) {
        this.cvLanguageService = cvLanguageService;
    }

    @PostMapping("/add")
    public Result add(@RequestBody CvLanguage cvLanguage){
        return this.cvLanguageService.add(cvLanguage);
    }

    @GetMapping("/getall")
    public DataResult<List<CvLanguage>> getAll(){
        return this.cvLanguageService.getAll();
    }

    @GetMapping("/getbyid")
    public DataResult<CvLanguage> getById(@RequestParam int id){
        return this.cvLanguageService.getById(id);
    }

    @GetMapping("/getByCandidateId")
    public DataResult<List<CvLanguage>> getByCandidateId(@RequestParam int id){
        return this.cvLanguageService.getByCandidateId(id);
    }
}
