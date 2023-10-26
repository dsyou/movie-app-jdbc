package pl.dsyou.movierating.movie.infrastructure.rest;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.dsyou.movierating.movie.application.command.*;

@RestController
@RequestMapping("/movies")
@RequiredArgsConstructor
class MoviesEditController {

    private final EditHandler editHandler;

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    void editMovie(@RequestBody @Valid EditCmd editCmd) {
        editHandler.handle(editCmd);
    }

}
