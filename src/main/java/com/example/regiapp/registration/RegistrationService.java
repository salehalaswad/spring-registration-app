package com.example.regiapp.registration;

import com.example.regiapp.user.User;
import com.example.regiapp.user.UserRole;
import com.example.regiapp.user.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegistrationService {
    private final UserService userService;
    private final EmailValidator emailValidator;
    public String register(RegistrationRequest request){
       boolean isValidEmail = emailValidator.test(request.getEmail());
       if (!isValidEmail){
           throw new IllegalStateException("email not valid");
       }
        return userService.signUpUser(
                new User(
                        request.getFirstName(),
                        request.getLastName(),
                        request.getEmail(),
                        request.getPassword(),
                        UserRole.USER
                )
        );
    }
}
