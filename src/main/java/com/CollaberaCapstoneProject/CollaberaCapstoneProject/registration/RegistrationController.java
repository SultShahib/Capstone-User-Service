package com.CollaberaCapstoneProject.CollaberaCapstoneProject.registration;

import lombok.AllArgsConstructor;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="api/v1/registration")
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class RegistrationController {
    private final RegistrationService registrationService;

    @PostMapping("/register")
    public String register(@RequestBody RegistrationRequest request) {
        return registrationService.register(request);

    }

    @PostMapping("/{firstname}/{lastname}/{email}/{password}")
    public ResponseEntity<String> registerUser(@PathVariable String firstname, @PathVariable String lastname, @PathVariable String email, @PathVariable String password) {
        return registrationService.registerUser(firstname, lastname, email, password);
    }
}
