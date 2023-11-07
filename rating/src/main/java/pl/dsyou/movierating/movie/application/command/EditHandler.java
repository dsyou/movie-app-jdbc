package pl.dsyou.movierating.movie.application.command;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.dsyou.command.CmdHandler;
import pl.dsyou.movierating.movie.domain.Movie;
import pl.dsyou.movierating.movie.domain.MovieRepository;
import pl.dsyou.movierating.movie.infrastructure.exception.MovieNotFoundException;
import pl.dsyou.result.Empty;
import pl.dsyou.result.Result;

@Slf4j
@Service
@Transactional
@AllArgsConstructor
public class EditHandler implements CmdHandler<EditCmd, Empty> {

    private final MovieRepository repository;

    @Override
    public Result<Empty> handle(EditCmd cmd) {
        String movieUuid = cmd.getMovieUuid();
        if (repository.existsByUuid(movieUuid)) {
            log.info("Editing movie with id:{}", movieUuid);
            Movie movie = repository.findBy(movieUuid)
                    .orElseThrow(() -> new MovieNotFoundException(movieUuid));
            movie.createDescription(cmd.getTitle(), cmd.getGenre(), cmd.getProductionDate());
            repository.save(movie);
            return Result.success();
        }

        return Result.failure();
    }
}
