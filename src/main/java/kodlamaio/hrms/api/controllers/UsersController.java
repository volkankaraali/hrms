package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.business.abstracts.UserService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.User;
import kodlamaio.hrms.entities.dtos.LoginDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UsersController {

    private UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public DataResult<LoginDto> login(@RequestParam String email,@RequestParam String password){
        return this.userService.login(email,password);
    }

    @PostMapping("/getByEmail")
    public DataResult<User> getByEmail(@RequestParam String email){
        return this.userService.getByEmail(email);
    }

    /*@GetMapping("/getall")
    public DataResult<List<User>> getAll(){
        return this.userService.getAll();
    }*/


}
