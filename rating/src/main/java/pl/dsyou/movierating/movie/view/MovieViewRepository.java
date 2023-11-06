package pl.dsyou.movierating.movie.view;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import pl.dsyou.domaindrivendesign.annotation.ReadOnlyRepository;

import java.util.Collection;
import java.util.Optional;

@ReadOnlyRepository
public interface MovieViewRepository extends CrudRepository<MovieView, Long> {
    @Query("SELECT * FROM movies")
    Collection<MovieProjection> findMovieProjectionAll();

    Optional<MovieProjection> findProjectionByUuid(String uuid);

    Optional<MovieView> findByUuid(String uuid);
}
