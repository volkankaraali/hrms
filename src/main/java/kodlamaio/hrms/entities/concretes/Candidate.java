package kodlamaio.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;


@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "candidates")
@AllArgsConstructor
@NoArgsConstructor
public class Candidate extends User{

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "identity_number")
    @Size(min = 11,max = 11)
    private String identityNumber;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @JsonIgnore
    @OneToMany(mappedBy = "candidate")
    private List<CvAbility> cvAbilities;

    @JsonIgnore
    @OneToMany(mappedBy = "candidate")
    private List<CvCoverLetter> cvCoverLetters;

    @JsonIgnore
    @OneToMany(mappedBy = "candidate")
    private List<CvEducation> cvEducations;

    @JsonIgnore
    @OneToMany(mappedBy = "candidate")
    private List<CvExperience> cvExperiences;

    @JsonIgnore
    @OneToMany(mappedBy = "candidate")
    private List<CvImage> cvImages;

    @JsonIgnore
    @OneToMany(mappedBy = "candidate")
    private List<CvLanguage> cvLanguages;

    @JsonIgnore
    @OneToMany(mappedBy = "candidate")
    private List<CvSocialMedia> cvSocialMedias;


}
