package pl.dsyou.movierating.movie.infrastructure.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.dsyou.movierating.movie.application.command.DeleteCmd;
import pl.dsyou.movierating.movie.application.command.DeleteHandler;

@RestController
@RequestMapping("api/v1/movies")
@RequiredArgsConstructor
class MoviesDeleteController {

    private final DeleteHandler deleteHandler;

    @DeleteMapping("{uuid}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteMovie(@PathVariable("uuid") String uuid) {
        deleteHandler.handle(new DeleteCmd(uuid));
    }
}
