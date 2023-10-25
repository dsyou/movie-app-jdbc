package pl.dsyou.movierating.movie.application.command;

import jakarta.validation.constraints.NotBlank;
import lombok.Value;

import java.util.Date;

@Value
public class CreateCmd {
    @NotBlank
    String title;
    @NotBlank
    String genre;
    @NotBlank
    Date productionDate;
}
