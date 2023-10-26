package pl.dsyou.movierating.movie.infrastructure.rest;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.dsyou.movierating.movie.application.command.CreateCmd;
import pl.dsyou.movierating.movie.application.command.CreateHandler;

@RestController
@RequestMapping("/movies")
@RequiredArgsConstructor
class MoviesCreateController {

    private final CreateHandler createHandler;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    void createMovie(@RequestBody @Valid CreateCmd createCmd) {
        createHandler.handle(createCmd);
    }
}
