package pl.dsyou.movierating.rating.view;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import pl.dsyou.domaindrivendesign.annotation.ReadOnlyRepository;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Optional;

@ReadOnlyRepository
interface RateViewRepository extends CrudRepository<RateView, Long> {

    @Query("SELECT AVG(score) FROM rates JOIN movies m WHERE m.uuid = :movieUuid")
    Optional<BigDecimal> avgRate(String movieUuid);

    default Optional<BigDecimal> avgRateToTwoRound(String movieUuid) {
        return this.avgRate(movieUuid).map(avgRate -> avgRate.setScale(2, RoundingMode.HALF_UP));
    }
}
