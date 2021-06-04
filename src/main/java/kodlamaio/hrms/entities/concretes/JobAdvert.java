package kodlamaio.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "job_adverts")
@NoArgsConstructor
@AllArgsConstructor
public class JobAdvert {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "job_title_id")
    private JobTitle jobTitle;

    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "employer_id")
    private Employer employer;

    @Column(name = "job_description")
    private String jobDescription;

    @Column(name = "min_salary",nullable = true)
    private int minSalary;

    @Column(name = "max_salary",nullable = true)
    private int maxSalary;

    @Column(name = "open_job_number")
    private int openJobNumber;

    @Column(name = "application_deadline",nullable = true)
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate applicationDeadline;

    @JsonIgnore
    @Column(name = "created_date")
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate createdDate=LocalDate.now();

    @JsonIgnore
    @Column(name = "is_active")
    private boolean isActive =true;

    @JsonIgnore
    @Column(name="is_deleted")
    private boolean isDeleted;


}
