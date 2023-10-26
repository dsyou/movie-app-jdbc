package pl.dsyou.movierating.rating.application.command;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.dsyou.command.CmdHandler;
import pl.dsyou.movierating.movie.domain.MovieRepository;
import pl.dsyou.movierating.rating.domain.RateRepository;
import pl.dsyou.result.Empty;
import pl.dsyou.result.Result;

@Service
@Transactional
@AllArgsConstructor
class RateAdditionHandler implements CmdHandler<RateAdditionCmd, Empty> {

    private final MovieRepository movieRepository;
    private final RateRepository ratingRepository;

    @Override
    public Result<Empty> handle(RateAdditionCmd command) {
        // todo verify if movie exist
        return null;
    }
}
