package pl.dsyou.movierating.rating.application.command;

import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Value;
import pl.dsyou.command.Command;

@Value
@EqualsAndHashCode(callSuper = true)
public class RateCreationCmd extends Command {
    @NotNull
    String movieId;
}
