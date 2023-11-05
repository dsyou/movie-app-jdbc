package pl.dsyou.movierating.movie.domain;

import lombok.Value;

import java.time.LocalDate;

@Value
public class MovieSnapshot {
    long id;
    Description description;

    @Value
    public static class Description {
        String title;
        String genre;
        LocalDate productionDate;
    }
}
