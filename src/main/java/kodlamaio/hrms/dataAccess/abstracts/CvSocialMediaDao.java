package kodlamaio.hrms.dataAccess.abstracts;

import kodlamaio.hrms.entities.concretes.CvExperience;
import kodlamaio.hrms.entities.concretes.CvSocialMedia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CvSocialMediaDao extends JpaRepository<CvSocialMedia,Integer> {

    @Query("From CvSocialMedia where id=:id")
    CvSocialMedia getById(int id);

    List<CvSocialMedia> getByCandidate_id(int id);
}
