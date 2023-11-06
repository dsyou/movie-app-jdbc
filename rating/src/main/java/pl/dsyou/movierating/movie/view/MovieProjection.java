package pl.dsyou.movierating.movie.view;

import java.time.LocalDate;

record MovieProjection(String uuid,
                       String title,
                       String genre,
                       LocalDate productionDate) {
}
