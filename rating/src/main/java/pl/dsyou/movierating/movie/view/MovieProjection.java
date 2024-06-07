package pl.dsyou.movierating.movie.view;

import java.time.LocalDate;

interface MovieProjection {
    String getUuid();

    String getTitle();

    String getGenre();

    LocalDate getProductionDate();
}
