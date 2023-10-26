package pl.dsyou.movierating.movie.application.command;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.dsyou.command.CmdHandler;
import pl.dsyou.movierating.movie.domain.MovieRepository;
import pl.dsyou.result.Empty;
import pl.dsyou.result.Result;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class DeleteHandler implements CmdHandler<DeleteCmd, Empty> {

    private final MovieRepository repository;

    @Override
    public Result<Empty> handle(DeleteCmd cmd) {
        String movieUuid = cmd.getMovieUuid();
        if (repository.existsByUuid(cmd.getMovieUuid())) {
            log.info("Deleting movie with uuid: {}", movieUuid);
            repository.deleteBy(movieUuid);
            // todo dsyou delete ratings
            return Result.success();
        }
        log.warn("Deleting movie doesn't exists uuid: {}", movieUuid);
        return Result.failure();
    }
}
