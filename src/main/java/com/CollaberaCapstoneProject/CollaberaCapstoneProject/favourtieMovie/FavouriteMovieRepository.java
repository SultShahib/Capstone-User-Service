package com.CollaberaCapstoneProject.CollaberaCapstoneProject.favourtieMovie;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;


@Repository
public interface FavouriteMovieRepository extends JpaRepository<FavouriteMovie, Long> {
    Optional<FavouriteMovie> findByMovieidAndUserid(String movieid, String userid);

    Void deleteByMovieidAndUserid(String movieid, String userid);

    void deleteByMovieid(Long moveid);

    Optional<FavouriteMovie> findByMovieid(String movieid);
}
