package kodlamaio.hrms.dataAccess.abstracts;

import kodlamaio.hrms.entities.concretes.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CandidateDao extends JpaRepository<Candidate,Integer> {

    @Query("From Candidate where isDeleted=false")
    List<Candidate> getNoDeletedCandidate();

    @Query("From Candidate where id=:candidateId")
    Candidate findById(int candidateId);
}
