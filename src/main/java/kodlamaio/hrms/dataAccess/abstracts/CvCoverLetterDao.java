package kodlamaio.hrms.dataAccess.abstracts;

import kodlamaio.hrms.entities.concretes.CvAbility;
import kodlamaio.hrms.entities.concretes.CvCoverLetter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CvCoverLetterDao extends JpaRepository<CvCoverLetter,Integer> {

    @Query("From CvCoverLetter where id=:id")
    CvCoverLetter getById(int id);

    List<CvCoverLetter> getByCandidate_id(int id);
}
