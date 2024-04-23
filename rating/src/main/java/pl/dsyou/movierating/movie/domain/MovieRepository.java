package pl.dsyou.movierating.movie.domain;

import pl.dsyou.domaindrivendesign.annotation.DomainRepository;

import java.util.Optional;

@DomainRepository
public interface MovieRepository {

    Movie save(Movie movie);

    void deleteBy(String uuid);

    Optional<Movie> findBy(String uuid);

    Optional<Movie> findByUuid(String movieUuid);

    boolean existsByUuid(String uuid);

    boolean existsByDescriptionTitle(String title);

    default boolean notExistsByDescriptionTitle(String title) {
        return !existsByDescriptionTitle(title);
    }

}
