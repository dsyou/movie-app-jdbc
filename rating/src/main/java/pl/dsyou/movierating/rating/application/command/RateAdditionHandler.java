package pl.dsyou.movierating.rating.application.command;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.dsyou.handler.CmdHandler;
import pl.dsyou.movierating.movie.domain.MovieRepository;
import pl.dsyou.movierating.rating.domain.RateRepository;

@Service
@Transactional
@AllArgsConstructor
class RateAdditionHandler implements CmdHandler<RateAdditionCmd> {
    private final MovieRepository movieRepository;
    private final RateRepository ratingRepository;

    @Override
    public void handle(RateAdditionCmd command) {
        // todo verify if movie exist
    }
}
