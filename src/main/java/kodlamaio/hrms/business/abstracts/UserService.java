package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.User;
import kodlamaio.hrms.entities.dtos.LoginDto;

import javax.xml.crypto.Data;
import java.util.List;

public interface UserService {

    DataResult<User> getByEmail(String email);

    DataResult<LoginDto> login(String email,String password);
}
