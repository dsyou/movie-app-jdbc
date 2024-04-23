package pl.dsyou.movierating.movie.infrastructure.persistence.jpa;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.dsyou.movierating.movie.domain.Movie;
import pl.dsyou.movierating.movie.domain.MovieRepository;

@Repository
interface MoveRepositoryJpa extends MovieRepository, CrudRepository<MovieEntity, Long> {

    default Movie save(Movie movie) {
        MovieEntity entity = MovieEntityFactory.createEntity(movie.getSnapshot());
        this.save(entity);

        return MovieEntityFactory.fromPersistence(entity);
    }
}
