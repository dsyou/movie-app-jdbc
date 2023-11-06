package pl.dsyou.movierating.movie.domain;

import lombok.Value;

import java.time.LocalDate;

@Value
public class Description {
    String title;
    String genre;
    LocalDate productionDate;
}
