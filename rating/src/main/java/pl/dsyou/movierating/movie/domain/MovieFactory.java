package pl.dsyou.movierating.movie.domain;

import pl.dsyou.domaindrivendesign.annotation.DomainFactory;

import java.time.LocalDate;
import java.util.UUID;

@DomainFactory
public class MovieFactory {
    public static Movie of(String title, String genre, LocalDate productionDate) {
        String uuid = UUID.randomUUID().toString();
        return new Movie(uuid, title, genre, productionDate);
    }

    public static Movie of(long id, String uuid, String title, String genre, LocalDate productionDate) {
        return new Movie(id,uuid, title, genre, productionDate);
    }

}
