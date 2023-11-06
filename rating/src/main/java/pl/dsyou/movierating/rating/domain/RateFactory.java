package pl.dsyou.movierating.rating.domain;

import java.math.BigDecimal;

public class RateFactory {

    public static Rate of(long movieId) {
        return new Rate(movieId);
    }

    public static Rate of(long movieId, BigDecimal rate) {
        return new Rate(movieId, rate);
    }
}
