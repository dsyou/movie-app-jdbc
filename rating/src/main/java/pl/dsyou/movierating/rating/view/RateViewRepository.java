package pl.dsyou.movierating.rating.view;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import pl.dsyou.domaindrivendesign.annotation.ReadOnlyRepository;

import java.math.BigDecimal;
import java.math.RoundingMode;

@ReadOnlyRepository
interface RateViewRepository extends CrudRepository<RateView, Long> {

    @Query("SELECT AVG(score) FROM rates WHERE movie = :movieId")
    BigDecimal avgRate(long movieId);

    default BigDecimal avgRateToTwoRound(long movieId) {
        BigDecimal avgRate = this.avgRate(movieId);
        return avgRate.setScale(2, RoundingMode.HALF_UP);
    }
}
