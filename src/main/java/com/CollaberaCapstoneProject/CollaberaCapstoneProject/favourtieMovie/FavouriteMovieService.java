package com.CollaberaCapstoneProject.CollaberaCapstoneProject.favourtieMovie;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class FavouriteMovieService {

    @Autowired
    FavouriteMovieRepository favouriteMovieRepository;

    public String addFavourite(FavouriteMovie favouriteMovie) {
        System.out.println("Added movies");
        Optional<FavouriteMovie> checkIfMovieExists = favouriteMovieRepository.findById(favouriteMovie.getMovieid());

        if(checkIfMovieExists.isPresent()) {
            System.out.println("I AM MASTER OF EUROPE NAPOLEON");
            checkIfMovieExists.ifPresent(existingMovie -> {
                favouriteMovieRepository.deleteByMovieid(existingMovie.getMovieid());
            });        }
        favouriteMovieRepository.save(favouriteMovie);

      return "movie added";
    }

    public List<FavouriteMovie> getAllFavouriteMovie() {
        System.out.println("Getting all favourite movies");
        System.out.println(favouriteMovieRepository.findAll());
     return favouriteMovieRepository.findAll();
    }


    public Optional<FavouriteMovie> checkFavouriteMovie(String movieid, String userid) {
       return favouriteMovieRepository.findByMovieidAndUserid(movieid, userid);
    }

    public Void deleteFavourite(String movieid, String userid) {
        return favouriteMovieRepository.deleteByMovieidAndUserid(movieid, userid);
    }

}
