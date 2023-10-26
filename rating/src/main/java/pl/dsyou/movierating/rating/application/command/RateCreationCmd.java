package pl.dsyou.movierating.rating.application.command;

import jakarta.validation.constraints.NotNull;
import lombok.Value;
import pl.dsyou.command.Command;

@Value
public class RateCreationCmd extends Command {
    @NotNull
    String movieId;
}
