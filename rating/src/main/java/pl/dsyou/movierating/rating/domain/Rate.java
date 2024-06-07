package pl.dsyou.movierating.rating.domain;

import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.Id;
import org.springframework.data.jdbc.core.mapping.AggregateReference;
import org.springframework.data.relational.core.mapping.Table;
import pl.dsyou.domaindrivendesign.annotation.AggregateRoot;
import pl.dsyou.domaindrivendesign.superclass.AggregateRootAbstract;
import pl.dsyou.movierating.movie.infrastructure.persistence.jpa.MovieEntity;
import pl.dsyou.result.Result;

import java.math.BigDecimal;

import static pl.dsyou.movierating.rating.infrastructure.persistence.RatingTableNames.RATES;

@AggregateRoot
@Table(RATES)
@EqualsAndHashCode(callSuper = false)
public class Rate extends AggregateRootAbstract {
    @Id
    private long id;
    private AggregateReference<MovieEntity, Long> movie;

    private BigDecimal rate;

    Rate(long movieId) {
        this.movie = AggregateReference.to(movieId);
        this.rate = new BigDecimal(0);
    }

    public Result addRate(BigDecimal rate) {
        RatePolicy ratePolicy = RatePolicy.defaultPolicy();
        Result result = ratePolicy.validate(rate);
        if (result.isSuccess()) {
            this.rate = rate;
        }

        return result;
    }
}
