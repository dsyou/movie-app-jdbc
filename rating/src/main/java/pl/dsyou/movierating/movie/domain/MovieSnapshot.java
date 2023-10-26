package pl.dsyou.movierating.movie.domain;

import lombok.Value;

import java.util.Date;

@Value
public class MovieSnapshot {
    long id;
    Description description;

    @Value
    public static class Description {
        String title;
        String genre;
        Date productionDate;
    }
}
