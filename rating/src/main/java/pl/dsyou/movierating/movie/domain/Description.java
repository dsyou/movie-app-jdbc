package pl.dsyou.movierating.movie.domain;

import lombok.Value;

import java.util.Date;

@Value
class Description {
    String title;
    String genre;
    Date productionDate;
}
