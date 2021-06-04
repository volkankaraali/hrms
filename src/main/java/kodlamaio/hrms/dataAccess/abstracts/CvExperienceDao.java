package kodlamaio.hrms.dataAccess.abstracts;

import kodlamaio.hrms.entities.concretes.CvEducation;
import kodlamaio.hrms.entities.concretes.CvExperience;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CvExperienceDao extends JpaRepository<CvExperience,Integer> {

    @Query("From CvExperience where id=:id")
    CvExperience getById(int id);

    List<CvExperience> getByCandidate_id(int id);
}
