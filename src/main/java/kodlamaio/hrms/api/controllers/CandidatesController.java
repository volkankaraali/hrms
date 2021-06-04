package kodlamaio.hrms.api.controllers;


import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.dtos.CandidateCvDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/candidates")
public class CandidatesController {

    private CandidateService candidateService;

    @Autowired
    public CandidatesController(CandidateService candidateService) {
        this.candidateService = candidateService;
    }

    @GetMapping("/getall")
    public DataResult<List<Candidate>> getAll(){ return this.candidateService.getAll();
    }

    @PostMapping("/add")
    public Result add(@Valid @RequestBody Candidate candidate){
        return this.candidateService.add(candidate);
    }

    @PostMapping("/passiveDelete")
    public Result delete(@RequestBody int candidateId){
        return this.candidateService.passiveDelete(candidateId);
    }

    @GetMapping("/getcandidatecvdto")
    public DataResult<CandidateCvDto> getCandidateCvById(@RequestParam int id){
        return this.candidateService.getCandidateCvById(id);
    }

    @GetMapping("/getById")
    public DataResult<Candidate> getById(@RequestParam int candidateId){
        return this.candidateService.getById(candidateId);
    }





    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDataResult<Object> handleValidationException(MethodArgumentNotValidException exceptions){
        Map<String, String> validationErrors =new HashMap<String,String>();
        for (FieldError fieldError:exceptions.getBindingResult().getFieldErrors()){
            validationErrors.put(fieldError.getField(),fieldError.getDefaultMessage());
        }

        ErrorDataResult<Object> errors= new ErrorDataResult<Object>(validationErrors,"dogrulama hatalari");
        return errors;
    }
}
