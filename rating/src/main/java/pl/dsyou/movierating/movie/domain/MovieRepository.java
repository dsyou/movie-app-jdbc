package pl.dsyou.movierating.movie.domain;

import org.springframework.data.repository.CrudRepository;
import pl.dsyou.domaindrivendesign.annotation.DomainRepository;

import java.util.Optional;

@DomainRepository
public interface MovieRepository extends CrudRepository<Movie, Long> {
    void deleteBy(String uuid);

    Optional<Movie> findBy(String uuid);

    boolean existsByUuid(String uuid);

    boolean existsByDescriptionTitle(String title);

    default boolean notExistsByDescriptionTitle(String title) {
        return !existsByDescriptionTitle(title);
    }
}
