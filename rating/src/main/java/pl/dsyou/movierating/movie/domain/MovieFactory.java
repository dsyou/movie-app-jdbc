package pl.dsyou.movierating.movie.domain;

import java.util.Date;

public class MovieFactory {
    public static Movie of(String title, String genre, Date productionDate) {
        return new Movie(title, genre, productionDate);
    }
}
