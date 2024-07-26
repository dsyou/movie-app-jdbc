package pl.dsyou.movierating.movie.application.command;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.dsyou.command.CmdHandler;
import pl.dsyou.movierating.movie.domain.Movie;
import pl.dsyou.movierating.movie.domain.MovieFactory;
import pl.dsyou.movierating.movie.domain.MovieRepository;
import pl.dsyou.movierating.movie.domain.event.CreatedMovie;
import pl.dsyou.movierating.movie.infrastructure.audit.MovieAuditPublisher;
import pl.dsyou.result.Empty;
import pl.dsyou.result.Result;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class CreateHandler implements CmdHandler<CreateCmd, Empty> {

    private final MovieRepository repository;
    private final ApplicationEventPublisher applicationEventPublisher;
    private final MovieAuditPublisher movieAuditPublisher;

    @Override
    public Result<Empty> handle(CreateCmd cmd) {
        if (repository.notExistsByDescriptionTitle(cmd.getTitle())) {
            Movie movie = MovieFactory.of(cmd.getTitle(), cmd.getGenre(), cmd.getProductionDate());
            long savedMovieId = repository.save(movie)
                    .getSnapshot()
                    .getId();

            applicationEventPublisher.publishEvent(new CreatedMovie(savedMovieId));
            movieAuditPublisher.publishAudit(Movie.class, movie.getUuid(), cmd);
            return Result.success();
        }

        // todo dsyou failure with another http status
        log.info("Movie with given title:{} already exists", cmd.getTitle());
        return Result.failure();
    }
}
