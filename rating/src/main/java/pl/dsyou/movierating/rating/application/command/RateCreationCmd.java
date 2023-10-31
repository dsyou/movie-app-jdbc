package pl.dsyou.movierating.rating.application.command;

import lombok.EqualsAndHashCode;
import lombok.Value;
import pl.dsyou.command.Command;

@Value
@EqualsAndHashCode(callSuper = true)
public class RateCreationCmd extends Command {
    long movieId;
}
