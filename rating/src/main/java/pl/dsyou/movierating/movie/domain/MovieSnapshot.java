package pl.dsyou.movierating.movie.domain;

import pl.dsyou.domaindrivendesign.superclass.DomainSnapshot;

import java.time.LocalDate;

public interface MovieSnapshot extends DomainSnapshot {
    String getTitle();

    String getGenre();

    LocalDate getProductionDate();
}
