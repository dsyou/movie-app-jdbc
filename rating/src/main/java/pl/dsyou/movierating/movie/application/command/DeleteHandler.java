package pl.dsyou.movierating.movie.application.command;

import lombok.AllArgsConstructor;
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
@AllArgsConstructor
public class DeleteHandler implements CmdHandler<DeleteCmd, Empty> {

    private final MovieRepository repository;

    @Override
    public Result<Empty> handle(DeleteCmd cmd) {
        log.info("Deleting movie with uuid:{}", cmd.getMovieId());
        // co jak nie ma uuid ?
        repository.deleteBy(cmd.getMovieId());

        return null;
    }
}
