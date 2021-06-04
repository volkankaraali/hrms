package kodlamaio.hrms.dataAccess.abstracts;

import kodlamaio.hrms.entities.concretes.CvEduGraduateType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CvEduGraduateTypeDao extends JpaRepository<CvEduGraduateType,Integer> {
}
