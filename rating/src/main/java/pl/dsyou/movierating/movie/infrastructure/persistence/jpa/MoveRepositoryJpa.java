package pl.dsyou.movierating.movie.infrastructure.persistence.jpa;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.dsyou.movierating.movie.domain.Movie;
import pl.dsyou.movierating.movie.domain.MovieRepository;

import java.util.Optional;

@Repository
interface MoveRepositoryJpa extends MovieRepository, CrudRepository<MovieEntity, Long> {

    @Override
    default boolean notExistsByDescriptionTitle(String title) {
        return MovieRepository.super.notExistsByDescriptionTitle(title);
    }

    Optional<MovieEntity> findByUuid(String uuid);

    default Optional<Movie> findMovieByUuid(String uuid) {
        return this.findByUuid(uuid).map(MovieEntityFactory::fromPersistence);
    }

    default Movie save(Movie movie) {
        MovieEntity entity = MovieEntityFactory.createEntity(movie.getSnapshot());
        MovieEntity saved = this.save(entity);

        return MovieEntityFactory.fromPersistence(saved);
    }

}
