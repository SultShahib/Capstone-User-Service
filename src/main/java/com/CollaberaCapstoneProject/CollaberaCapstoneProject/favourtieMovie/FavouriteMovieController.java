package com.CollaberaCapstoneProject.CollaberaCapstoneProject.favourtieMovie;


import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@AllArgsConstructor
@RequestMapping(path ="api/v1/favourite")
public class FavouriteMovieController {

    @Autowired
    FavouriteMovieService favouriteMovieService;

    @Autowired
    GetFavouriteMovies getFavouriteMovies;

    @Autowired
    DeleteFavouriteMovie deleteFavouriteMovie;


    @GetMapping("/getAllFavouriteMovies")
//    public ResponseEntity<String> getAllFavouriteMovie() {
    public List<FavouriteMovie> getAllFavouriteMovie() {
//        HttpHeaders responseHeaders = new HttpHeaders();
        System.out.println(favouriteMovieService.getAllFavouriteMovie());
//        responseHeaders.add("Working now", "Working now");

        return favouriteMovieService.getAllFavouriteMovie();
    }

    @PostMapping("/addFavourite/{movieid}/{userid}")
    public String saveFavourtieMovie(@PathVariable Long movieid, @PathVariable Long userid) {
        return favouriteMovieService.addFavourite(new FavouriteMovie(movieid, userid));
    }

    @GetMapping("/getFavouriteMovies/{userid}")
    public List<String> getFavouriteMovies(@PathVariable String userid) {
        return getFavouriteMovies.getFavouriteMovies(userid);
    }

    @GetMapping("/checkFavouriteMovie/{movieid}/{userid}")
    public Optional<FavouriteMovie> checkFavouriteMovie(@PathVariable String movieid, @PathVariable String userid) {
        return favouriteMovieService.checkFavouriteMovie(movieid, userid);
    }

    @DeleteMapping("/deleteFavouriteMovie/{movieid}/{userid}")
    public void deleteFavouriteMovie(@PathVariable String movieid, @PathVariable String userid) {
        deleteFavouriteMovie.deleteFavouriteMovie(movieid, userid);
    }

}
