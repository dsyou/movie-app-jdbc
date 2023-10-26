package pl.dsyou.movierating.movie.application.command;

import jakarta.validation.constraints.NotBlank;
import lombok.Value;
import pl.dsyou.command.Command;

@Value
public class EditCmd extends Command {
    String uuid;
    @NotBlank
    String title;
    @NotBlank
    String genre;
    @NotBlank
    String productionDate;
}
