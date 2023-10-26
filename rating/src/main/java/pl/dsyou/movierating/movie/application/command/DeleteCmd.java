package pl.dsyou.movierating.movie.application.command;

import lombok.Value;
import pl.dsyou.command.Command;

@Value
public class DeleteCmd extends Command {
    String movieId;
}
