package com.CollaberaCapstoneProject.CollaberaCapstoneProject.login;

import com.CollaberaCapstoneProject.CollaberaCapstoneProject.appuser.AppUser;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path="api/v1/login")
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class LoginController {

    private final LoginService loginService;

//    @GetMapping()
//    public Optional<AppUser> login(@RequestBody LoginRequest request) {
////    public String login(@RequestBody LoginRequest request) {
//        return loginService.login(request);
//
//    }

    @GetMapping("/{email}/{password}")
    public ResponseEntity<Optional<AppUser>> loginUser(@PathVariable String email, @PathVariable String password) {
     return loginService.loginUser(email, password);

    }
}
