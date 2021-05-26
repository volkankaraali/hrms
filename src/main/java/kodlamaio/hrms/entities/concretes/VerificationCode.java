package kodlamaio.hrms.entities.concretes;

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

    @Column(name = "is_verified")
    private boolean isVerified=false;

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
