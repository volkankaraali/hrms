package kodlamaio.hrms.dataAccess.abstracts;

import kodlamaio.hrms.entities.concretes.CvAbility;
import kodlamaio.hrms.entities.concretes.CvImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CvImageDao extends JpaRepository<CvImage,Integer> {

    @Query("From CvImage where id=:id")
    CvImage getById(int id);

    List<CvImage> getByCandidate_id(int id);
}
