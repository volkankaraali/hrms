package kodlamaio.hrms.dataAccess.abstracts;


import kodlamaio.hrms.entities.concretes.User;
import kodlamaio.hrms.entities.dtos.LoginDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface UserDao extends JpaRepository<User,Integer> {

    User getByEmail(String email);

    @Query("Select new kodlamaio.hrms.entities.dtos.LoginDto(u.id,u.email,u.password) From User u where u.email=:email")
    LoginDto getLoginDtoByEmail(String email);
}
