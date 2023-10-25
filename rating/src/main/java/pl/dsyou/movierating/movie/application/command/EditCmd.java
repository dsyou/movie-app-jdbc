package pl.dsyou.movierating.movie.application.command;

import jakarta.validation.constraints.NotBlank;
import lombok.Value;

@Value
public class EditCmd {
    String uuid;

    @NotBlank
    String title;
    @NotBlank
    String genre;
    @NotBlank
    String productionDate;
}
