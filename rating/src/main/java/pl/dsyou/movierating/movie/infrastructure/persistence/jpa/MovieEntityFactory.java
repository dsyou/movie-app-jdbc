package pl.dsyou.movierating.movie.infrastructure.persistence.jpa;

import pl.dsyou.movierating.movie.domain.Movie;
import pl.dsyou.movierating.movie.domain.MovieFactory;
import pl.dsyou.movierating.movie.domain.MovieSnapshot;

class MovieEntityFactory {
    public static MovieEntity createEntity(MovieSnapshot snap) {
        return new MovieEntity(snap.getUuid(),
                snap.getTitle(), snap.getGenre(), snap.getProductionDate()
        );
    }

    public static Movie fromPersistence(MovieSnapshot snap) {
        return MovieFactory.of(snap.getId(),snap.getUuid(), snap.getTitle(), snap.getGenre(), snap.getProductionDate());
    }
}
