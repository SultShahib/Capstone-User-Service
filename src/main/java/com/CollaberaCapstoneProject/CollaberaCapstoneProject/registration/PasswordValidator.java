package com.CollaberaCapstoneProject.CollaberaCapstoneProject.registration;

import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


@Service
public class PasswordValidator {

    public static final Pattern VALID_PASSWORD_REGEX =
            Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$", Pattern.CASE_INSENSITIVE);

    public boolean test(String password) {
        Matcher matcher = VALID_PASSWORD_REGEX.matcher(password);

        return matcher.find();
    }

}
