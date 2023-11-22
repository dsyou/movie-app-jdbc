package pl.dsyou.movierating.rating.view;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.ReadOnlyProperty;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;

import static pl.dsyou.movierating.rating.infrastructure.persistence.RatingTableNames.RATES;

@Table(RATES)
@Getter
@AllArgsConstructor
class RateView {
    @Id
    private final long id;
    @Column("movie")
    @ReadOnlyProperty
    private final long movieUuid;
    @ReadOnlyProperty
    private final BigDecimal score;
}
