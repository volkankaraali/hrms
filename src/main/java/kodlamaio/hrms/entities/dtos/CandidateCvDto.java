package kodlamaio.hrms.entities.dtos;

import kodlamaio.hrms.entities.concretes.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CandidateCvDto {


    private Candidate candidate;

    private List<CvAbility> cvAbilities;

    private List<CvCoverLetter> cvCoverLetters;

    private List<CvEducation> cvEducations;

    private List<CvExperience> cvExperiences;

    private List<CvImage> cvImage;

    private List<CvLanguage> cvLanguages;

    private List<CvSocialMedia> cvSocialMedias;

}
