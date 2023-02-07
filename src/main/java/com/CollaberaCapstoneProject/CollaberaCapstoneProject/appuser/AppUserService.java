package com.CollaberaCapstoneProject.CollaberaCapstoneProject.appuser;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AppUserService implements UserDetailsService {
    private final static String USER_NOT_FOUND_MSG = "User with email %s not found, please register";

    @Autowired
    private final AppUserRepository appUserRepository;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return appUserRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException(String.format(USER_NOT_FOUND_MSG, email)));
    }

    public String signUpUser(AppUser appUser) {
         boolean userExists = appUserRepository.findByEmail(appUser.getEmail()).isPresent();

         if(userExists) {
             System.out.println("Email already taken!");
             throw new IllegalStateException("Email Already Taken!");
         }

        String encodedPassword =  bCryptPasswordEncoder.encode(appUser.getPassword());
         appUser.setPassword(encodedPassword);

         appUserRepository.save(appUser);

//         Send confirmation token
        return "It works signing up user with encoded password";

    }

    public ResponseEntity<String> registerUser(AppUser appUser) {
         boolean userExists = appUserRepository.findByEmail(appUser.getEmail()).isPresent();
        HttpHeaders responseHeaders = new HttpHeaders();

         if(userExists) {
             System.out.println("Email already taken!");
             responseHeaders.add("Email already taken", "Email already taken");
             return new ResponseEntity<>("Email already taken", responseHeaders, 403);
         }

        String encodedPassword =  bCryptPasswordEncoder.encode(appUser.getPassword());
         appUser.setPassword(encodedPassword);

         appUserRepository.save(appUser);

//         Send confirmation token
        return new ResponseEntity<>("Registered Successfully", responseHeaders, 200);

    }

    public Optional<AppUser> loginUser(Optional<AppUser> appUser) {
    return appUser;
//        return "No user found";
    }
}
