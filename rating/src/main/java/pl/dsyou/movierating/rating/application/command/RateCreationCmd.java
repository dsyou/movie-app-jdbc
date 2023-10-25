package pl.dsyou.movierating.rating.application.command;

import jakarta.validation.constraints.NotNull;
import lombok.Value;

@Value
public class RateCreationCmd {
    @NotNull
    String movieId;
}
