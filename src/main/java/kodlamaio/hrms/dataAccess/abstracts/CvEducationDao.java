package kodlamaio.hrms.dataAccess.abstracts;

import kodlamaio.hrms.entities.concretes.CvCoverLetter;
import kodlamaio.hrms.entities.concretes.CvEducation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CvEducationDao extends JpaRepository<CvEducation,Integer> {

    @Query("From CvEducation where id=:id")
    CvEducation getById(int id);

    List<CvEducation> getByCandidate_id(int id);
}
