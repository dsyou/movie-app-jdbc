package pl.dsyou.movierating.rating.application.command;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Value;

@Value
class RateAdditionCmd {
    @NotNull
    long movieId;

    @Min(1)
    @Max(10)
    float rank;
}
