package pl.dsyou.movierating.movie.infrastructure.persistence.jpa;

import lombok.Value;

import java.time.LocalDate;

@Value
class DescriptionEntity {
    String title;
    String genre;
    LocalDate productionDate;
}
