package com.CollaberaCapstoneProject.CollaberaCapstoneProject.login;

import com.CollaberaCapstoneProject.CollaberaCapstoneProject.appuser.AppUser;
import com.CollaberaCapstoneProject.CollaberaCapstoneProject.appuser.AppUserRepository;
import com.CollaberaCapstoneProject.CollaberaCapstoneProject.appuser.AppUserService;
import com.CollaberaCapstoneProject.CollaberaCapstoneProject.registration.EmailValidator;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class LoginService {
    private final AppUserService appUserService;
    private final PasswordEncoder passwordEncoder;
    private final EmailValidator emailValidator;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    private final AppUserRepository appUserRepository;
    public Optional<AppUser> login(LoginRequest request) {
        boolean checkUserExists = appUserRepository.findByEmail(request.getEmail()).isPresent();
        boolean userAccExists = passwordEncoder.matches(request.getPassword(), appUserRepository.findByEmail(request.getEmail()).get().getPassword());
        Optional<AppUser> userExists = appUserRepository.findByEmail(request.getEmail());


        if(!checkUserExists) {
            throw new IllegalStateException("Email not found, please register!");
        }

        if( !userAccExists) {
            throw new IllegalStateException("Incorrect password, try again!");
        }


        return appUserService.loginUser(userExists);
    }

    public ResponseEntity<Optional<AppUser>> loginUser(String email, String password) {
        boolean checkUserExists = appUserRepository.findByEmail(email).isPresent();
        boolean userAccExists = passwordEncoder.matches(password, appUserRepository.findByEmail(email).get().getPassword());
        Optional<AppUser> wrongPasswordUser = appUserRepository.findByEmailAndPassword(email, password);
        Optional<AppUser> userExists = appUserRepository.findByEmail(email);
            HttpHeaders responseHeaders = new HttpHeaders();

            if(!checkUserExists) {
//            throw new IllegalStateException("Email not found, please register!");
            responseHeaders.add("Email-not-found-error", "Email not found, please register");
            return new ResponseEntity<>(userExists, responseHeaders, 401);
        }

        if( !userAccExists) {
//            throw new IllegalStateException("Incorrect password, try again!");
            responseHeaders.add("Incorrect-password-error", "Incorrect password, please try again");
            return new ResponseEntity<>(userExists, responseHeaders, 400);
        }


        responseHeaders.add("Login Successful", "Login succussful");
        return new ResponseEntity<>(userExists, responseHeaders, 200);
    }
}

