package pl.dsyou.movierating.movie.application.command;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Value;
import pl.dsyou.command.Command;

import java.time.LocalDate;

@Value
@EqualsAndHashCode(callSuper = true)
public class CreateCmd extends Command {
    @NotBlank
    String title;
    @NotBlank
    String genre;
    @NotNull
    LocalDate productionDate;
}

