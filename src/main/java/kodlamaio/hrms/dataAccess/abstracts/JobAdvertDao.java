package kodlamaio.hrms.dataAccess.abstracts;

import kodlamaio.hrms.entities.concretes.JobAdvert;
import kodlamaio.hrms.entities.dtos.ActiveJobAdvertDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface JobAdvertDao extends JpaRepository<JobAdvert, Integer> {

    @Query("From JobAdvert where isActive=true and isDeleted=false")
    List<JobAdvert> getAllActive();

    @Query("Select new kodlamaio.hrms.entities.dtos.ActiveJobAdvertDto(e.companyName,jt.title,j.openJobNumber,j.createdDate, j.applicationDeadline) from JobAdvert j inner join j.employer e inner join j.jobTitle jt where j.isActive=true order by j.createdDate Desc")
    List<ActiveJobAdvertDto> getAllActiveByCreatedDate();

    @Query("Select new kodlamaio.hrms.entities.dtos.ActiveJobAdvertDto(e.companyName,jt.title,j.openJobNumber,j.createdDate, j.applicationDeadline) from JobAdvert j inner join j.employer e inner join j.jobTitle jt where j.isActive=true and e.id=:employerId order by j.createdDate Desc")
    List<ActiveJobAdvertDto> getAllActiveByEmployer(int employerId);

    @Query("From JobAdvert where id=:id")
    JobAdvert getJobAdvertById(int id);

    @Query("Select new kodlamaio.hrms.entities.dtos.ActiveJobAdvertDto(e.companyName,jt.title,j.openJobNumber,j.createdDate, j.applicationDeadline) " +
            "from JobAdvert j " +
            "inner join j.employer e " +
            "inner join j.jobTitle jt")
    List<ActiveJobAdvertDto> getActiveJobAdvert();

}
