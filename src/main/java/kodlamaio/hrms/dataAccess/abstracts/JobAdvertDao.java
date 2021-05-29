package kodlamaio.hrms.dataAccess.abstracts;

import kodlamaio.hrms.entities.concretes.JobAdvert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface JobAdvertDao extends JpaRepository<JobAdvert, Integer> {

    @Query("From JobAdvert where isActive=true")
    List<JobAdvert> getAllActive();

    @Query("From JobAdvert where isActive=true Order By createdDate Desc")
    List<JobAdvert> getAllActiveByCreatedDate();

    @Query("From JobAdvert where isActive= true and employer.id=:employerId")
    List<JobAdvert> getAllActiveByEmployer(int employerId);

    @Query("From JobAdvert where id=:id")
    JobAdvert getJobAdvertById(int id);

}
