package pl.dsyou.movierating.movie.application.command;

import lombok.EqualsAndHashCode;
import lombok.Value;
import pl.dsyou.command.Command;

@Value
@EqualsAndHashCode(callSuper = true)
public class DeleteCmd extends Command {
    String movieUuid;
}
