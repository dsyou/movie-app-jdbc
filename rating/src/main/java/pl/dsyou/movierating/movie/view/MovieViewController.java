package pl.dsyou.movierating.movie.view;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.dsyou.movierating.movie.infrastructure.exception.MovieNotFoundException;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("movies")
@RequiredArgsConstructor
class MovieViewController {

    private final MovieViewRepository repository;

    @GetMapping("{uuid}")
    @ResponseStatus(HttpStatus.OK)
    public MovieProjection getMovie(@PathVariable String uuid) {
        log.info("Accessing movie by uuid: {}", uuid);
        return repository.findProjectionByUuid(uuid)
                .orElseThrow(() -> new MovieNotFoundException(uuid));
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<MovieProjection> getMovies() {
        log.info("Accessing all movies");
        return (List<MovieProjection>) repository.findMovieProjectionAll();
    }

}
