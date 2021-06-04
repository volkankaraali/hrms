package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.business.abstracts.CvImageService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.concretes.CvExperience;
import kodlamaio.hrms.entities.concretes.CvImage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/cvimages")
public class CvImagesController {

    private CvImageService cvImageService;
    private CandidateService candidateService;

    @Autowired
    public CvImagesController(CvImageService cvImageService,CandidateService candidateService) {
        this.cvImageService = cvImageService;
        this.candidateService=candidateService;
    }

    @PostMapping("/add")
    public Result add(@RequestParam int candidateId, @RequestParam MultipartFile file){
        Candidate candidate=this.candidateService.getById(candidateId).getData();
        CvImage cvImage=new CvImage();
        cvImage.setCandidate(candidate);
        return this.cvImageService.add(cvImage,file);
    }

    @GetMapping("/getall")
    public DataResult<List<CvImage>> getAll(){
        return this.cvImageService.getAll();
    }

    @GetMapping("/getbyid")
    public DataResult<CvImage> getById(@RequestParam int id){
        return this.cvImageService.getById(id);
    }

    @GetMapping("/getByCandidateId")
    public DataResult<List<CvImage>> getByCandidateId(@RequestParam int id){
        return this.cvImageService.getByCandidateId(id);
    }
}
