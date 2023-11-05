package pl.dsyou.movierating.movie.domain;

import lombok.Value;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Value
public class Description {
    String title;
    String genre;
    LocalDate productionDate;
}
