package com.CollaberaCapstoneProject.CollaberaCapstoneProject.registration;

import com.CollaberaCapstoneProject.CollaberaCapstoneProject.appuser.AppUser;
import com.CollaberaCapstoneProject.CollaberaCapstoneProject.appuser.AppUserRole;
import com.CollaberaCapstoneProject.CollaberaCapstoneProject.appuser.AppUserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegistrationService {
    private final AppUserService appUserService;
    private final EmailValidator emailValidator;
    private final PasswordValidator passwordValidator;
    public String register(RegistrationRequest request) {
        boolean isValidEmail = emailValidator.test(request.getEmail());

        if(!isValidEmail) {
            throw new IllegalStateException("The email is not valid!!");
        }
        return appUserService.signUpUser(new AppUser(request.getFirstname(), request.getLastname(), request.getEmail(), request.getPassword(), AppUserRole.USER));
    }

    public ResponseEntity<String> registerUser(String firstname, String lastname, String email, String password) {
        boolean isValidEmail = emailValidator.test(email);
//        boolean isValidPassword = passwordValidator.test(password);
        HttpHeaders responseHeaders = new HttpHeaders();

        if(!isValidEmail) {
            responseHeaders.add("Invalid email format", "Invalid email format");
            return new ResponseEntity<>("Invalid Email Format", responseHeaders, 400);
        }

        if(password.length() < 8) {
            responseHeaders.add("Invalid password", "Invalid password");
//            TODO: add proper password validation later (uppercase, special character)
            return new ResponseEntity<>("Password Must be at least 8 Characters Long", responseHeaders, 401);
        }
        return appUserService.registerUser(new AppUser(firstname, lastname, email, password, AppUserRole.USER));
    }
}

