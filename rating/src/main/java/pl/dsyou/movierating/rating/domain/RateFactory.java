package pl.dsyou.movierating.rating.domain;

public class RateFactory {
    public static Rate of(long movieId) {
        return new Rate(movieId);
    }
}
