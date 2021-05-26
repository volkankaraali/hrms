package kodlamaio.hrms.dataAccess.abstracts;

import kodlamaio.hrms.entities.concretes.VerificationCode;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VerificationCodeDao extends JpaRepository<VerificationCode,Integer> {
}
