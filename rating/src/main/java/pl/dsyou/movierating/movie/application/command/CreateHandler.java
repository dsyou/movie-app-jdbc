package pl.dsyou.movierating.movie.application.command;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.dsyou.command.CmdHandler;
import pl.dsyou.movierating.movie.domain.Movie;
import pl.dsyou.movierating.movie.domain.MovieFactory;
import pl.dsyou.movierating.movie.domain.MovieRepository;
import pl.dsyou.result.Empty;
import pl.dsyou.result.Result;

@Service
@Transactional
@RequiredArgsConstructor
public class CreateHandler implements CmdHandler<CreateCmd, Empty> {

    private final MovieRepository repository;

    @Override
    public Result<Empty> handle(CreateCmd cmd) {
        if (repository.notExistsByTitle(cmd.getTitle())) {
            Movie movie = MovieFactory.of(cmd.getTitle(), cmd.getGenre(), cmd.getProductionDate());
            repository.save(movie);
            return Result.success();
        }
        return Result.failure();
    }
}
