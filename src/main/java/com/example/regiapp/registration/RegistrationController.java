package com.example.regiapp.registration;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/registration")
@AllArgsConstructor
public class RegistrationController {

    private RegistrationService registrationService;
    @PostMapping
    public String register(@RequestBody RegistrationRequest request){
        System.out.println("request: "+ request);
        String s = "{" +
                "id: 1, " +
                "email: s.as@outlook.de," +
                "enabled: true, " +
                "firstName: Saleh, " +
                "lastName: Alaswad, " +
                "locked: true," +
                "password: loveislove," +
                "userRole: USER";

        RegistrationRequest r= new RegistrationRequest("Salah","Alaswad","sex@germany.de","sexisgoof");
        return  registrationService.register(r);
    }
}
