package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.UserService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.dataAccess.abstracts.UserDao;
import kodlamaio.hrms.entities.concretes.User;
import kodlamaio.hrms.entities.dtos.LoginDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserManager implements UserService {

    private UserDao userDao;

    @Autowired
    public UserManager(UserDao userDao) {
        this.userDao = userDao;
    }


    @Override
    public DataResult<User> getByEmail(String email) {
        return new SuccessDataResult<User>(this.userDao.getByEmail(email),"listelendi");
    }

    @Override
    public DataResult<LoginDto> login(String email,String password) {
        User user=this.userDao.getByEmail(email);

        if (user==null){
            return new ErrorDataResult<>("böyle bir kullanici bulunmamaktadir");
        }

        LoginDto loginDto=new LoginDto();
        loginDto.setId(user.getId());
        loginDto.setEmail(user.getEmail());
        loginDto.setPassword(user.getPassword());

        if (!password.equals(loginDto.getPassword())){
            return new ErrorDataResult<>("sifre yanlis");
        }

        return new SuccessDataResult<LoginDto>(this.userDao.getLoginDtoByEmail(email),"giris basarili");

    }
}
