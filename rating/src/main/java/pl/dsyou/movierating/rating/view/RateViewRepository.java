package pl.dsyou.movierating.rating.view;

import org.springframework.data.repository.CrudRepository;
import pl.dsyou.domaindrivendesign.annotation.ReadOnlyRepository;

@ReadOnlyRepository
interface RateViewRepository extends CrudRepository<RateView, Long> {
    // countAvgByMovieId(movieId)
}
