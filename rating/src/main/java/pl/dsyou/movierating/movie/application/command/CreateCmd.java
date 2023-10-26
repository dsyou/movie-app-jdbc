package pl.dsyou.movierating.movie.application.command;

import jakarta.validation.constraints.NotBlank;
import lombok.Value;
import pl.dsyou.command.Command;

import java.util.Date;

@Value
public class CreateCmd extends Command {
    @NotBlank
    String title;
    @NotBlank
    String genre;
    @NotBlank
    Date productionDate;
}
