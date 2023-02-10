package com.CollaberaCapstoneProject.CollaberaCapstoneProject.favourtieMovie;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name="shahib_favourite_movie")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="shahib_favourite_movie")
public class FavouriteMovie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long favid;
    private Long movieid;
    private Long userid;

    public FavouriteMovie(Long movieid, Long userid) {
        this.movieid = movieid;
        this.userid = userid;
    }
}
