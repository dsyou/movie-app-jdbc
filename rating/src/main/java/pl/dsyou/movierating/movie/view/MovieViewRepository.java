package pl.dsyou.movierating.movie.view;

import org.springframework.data.repository.CrudRepository;
import pl.dsyou.domaindrivendesign.annotation.ReadOnlyRepository;

import java.util.Optional;

@ReadOnlyRepository
public interface MovieViewRepository extends CrudRepository<MovieView, String> {
    Optional<MovieView> findByUuid(String uuid);
}
