package kodlamaio.hrms.dataAccess.abstracts;


import kodlamaio.hrms.entities.concretes.CvExperience;
import kodlamaio.hrms.entities.concretes.CvLanguage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CvLanguageDao extends JpaRepository<CvLanguage,Integer> {

    @Query("From CvLanguage where id=:id")
    CvLanguage getById(int id);

    List<CvLanguage> getByCandidate_id(int id);
}
