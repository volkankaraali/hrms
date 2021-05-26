package kodlamaio.hrms.core.validation;

import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class EmailValidationManager implements ValidationService{



    @Override
    public String sendCode(String email) {

        //created random code
        UUID uuid=UUID.randomUUID();
        String code=uuid.toString();
        //mail gonderme islemleri yapilir
        System.out.println("Dogrulama maili gonderildi: "+email+"\nKod: "+code);

        return code;

    }
}
