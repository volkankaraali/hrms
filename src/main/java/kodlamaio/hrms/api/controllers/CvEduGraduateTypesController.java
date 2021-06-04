package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.business.abstracts.CvEduGraduateTypeService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CvEduGraduateType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cvEducationGraduateTypes")
public class CvEduGraduateTypesController {

    private CvEduGraduateTypeService cvEduGraduateTypeService;

    @Autowired
    public CvEduGraduateTypesController(CvEduGraduateTypeService cvEduGraduateTypeService) {
        this.cvEduGraduateTypeService = cvEduGraduateTypeService;
    }

    @PostMapping("/add")
    public Result add(@RequestBody CvEduGraduateType cvEduGraduateType){
        return this.cvEduGraduateTypeService.add(cvEduGraduateType);
    }

    @GetMapping("/getall")
    public DataResult<List<CvEduGraduateType>> getAll(){
        return this.cvEduGraduateTypeService.getAll();
    }
}
