package pl.dsyou.movierating.movie.infrastructure.rest;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.dsyou.movierating.movie.application.command.*;
import pl.dsyou.movierating.rating.application.command.RateCreationHandler;

@RestController
@RequestMapping("/movies")
@RequiredArgsConstructor
class MoviesController {

    private final CreateHandler createHandler;
    private final EditHandler editHandler;
    private final DeleteHandler deleteHandler;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    void createMovie(@RequestBody @Valid CreateCmd createCmd) {
        createHandler.handle(createCmd);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    void editMovie(@RequestBody @Valid EditCmd editCmd) {
        editHandler.handle(editCmd);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteMovie(@PathVariable("id") String id) {
        deleteHandler.handle(new DeleteCmd(id));
    }

}
