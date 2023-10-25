package pl.dsyou.movierating.movie.domain.exception;

import pl.dsyou.exception.ParseException;

public class MovieDateParseException extends ParseException {
    public MovieDateParseException(String productionDate) {
        super("Cannot parse movie with productionDate: " + productionDate);
    }
}
