package pl.dsyou.movierating.rating.application.command;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Value;
import pl.dsyou.command.Command;

@Value
class RateAdditionCmd extends Command {
    @NotNull
    long movieId;
    @Min(1)
    @Max(10)
    float rank;
}
