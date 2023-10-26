package pl.dsyou.movierating.movie.application.command;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.dsyou.command.CmdHandler;
import pl.dsyou.movierating.movie.domain.Movie;
import pl.dsyou.movierating.movie.domain.MovieRepository;
import pl.dsyou.movierating.movie.domain.exception.MovieNotFoundException;
import pl.dsyou.result.Empty;
import pl.dsyou.result.Result;

@Slf4j
@Service
@Transactional
@AllArgsConstructor
public class EditHandler implements CmdHandler<EditCmd, Empty> {
    private final MovieRepository repository;

    @Override
    public Result<Empty> handle(EditCmd command) {
        log.info("Editing movie with id:{}", command.getUuid());
        Movie movie = repository.findBy(command.getUuid()).
                orElseThrow(() -> new MovieNotFoundException(command.getUuid()));

        repository.save(movie);
        return null;
    }
}
