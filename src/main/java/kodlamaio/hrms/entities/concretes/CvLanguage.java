package kodlamaio.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;


@Data
@Entity
@Table(name="cv_languages")
@NoArgsConstructor
@AllArgsConstructor
public class CvLanguage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToOne()
    @JoinColumn(name="candidate_id")
    private Candidate candidate;

    @Column(name = "language_name")
    private String languageName;

    @Column(name = "level")
    private char level;

    @Column(name = "created_date")
    private LocalDate createdDate=LocalDate.now();

    @Column(name = "is_active")
    private boolean isActive;
}
