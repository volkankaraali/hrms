package kodlamaio.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name="verification_codes")
@AllArgsConstructor
@NoArgsConstructor
public class VerificationCode {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "user_id")
    private int userId;

    @Column(name = "code")
    private String code;

    @JsonIgnore
    @Column(name = "is_verified")
    private boolean isVerified=false;

    @JsonIgnore
    @Column(name = "created_date" ,columnDefinition = "Date defult CURRENT_DATE")
    private LocalDate creadtedDate=LocalDate.now();

    public VerificationCode(int userId, String code, boolean isVerified, LocalDate creadtedDate) {
        super();
        this.userId = userId;
        this.code = code;
        this.isVerified = isVerified;
        this.creadtedDate = creadtedDate;
    }
}
