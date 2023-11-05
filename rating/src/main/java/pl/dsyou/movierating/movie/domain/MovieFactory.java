package pl.dsyou.movierating.movie.domain;

import java.time.LocalDate;

public class MovieFactory {
    public static Movie of(String title, String genre, LocalDate productionDate) {
        return new Movie(title, genre, productionDate);
    }
}
