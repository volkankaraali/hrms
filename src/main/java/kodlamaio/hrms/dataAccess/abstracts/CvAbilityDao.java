package kodlamaio.hrms.dataAccess.abstracts;

import kodlamaio.hrms.entities.concretes.CvAbility;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CvAbilityDao extends JpaRepository<CvAbility, Integer> {

    @Query("From CvAbility where id=:id")
    CvAbility getById(int id);

    List<CvAbility> getByCandidate_id(int id);

}
