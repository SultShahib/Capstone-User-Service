//package com.CollaberaCapstoneProject.CollaberaCapstoneProject.registration;
//
//
//import com.CollaberaCapstoneProject.CollaberaCapstoneProject.appuser.AppUser;
//import com.CollaberaCapstoneProject.CollaberaCapstoneProject.appuser.AppUserRepository;
//import com.CollaberaCapstoneProject.CollaberaCapstoneProject.appuser.AppUserRole;
//import com.CollaberaCapstoneProject.CollaberaCapstoneProject.appuser.AppUserService;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class UserConfig {
//
//    @Bean
//    CommandLineRunner commandLineRunner(AppUserService appUserService) {
//        return args -> {
//            System.out.println("@@@@@@@@@@Command line runner being activated@@@@@@@@@@");
//            appUserService.registerUser(new AppUser("admin", "lastname", "admin@gmail.com", "Admin123!", AppUserRole.ADMIN));
//        };
//
//    }
//}
