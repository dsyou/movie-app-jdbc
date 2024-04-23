package pl.dsyou.movierating.rating.application.command;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.dsyou.command.CmdHandler;
import pl.dsyou.movierating.movie.domain.MovieRepository;
import pl.dsyou.movierating.rating.domain.Rate;
import pl.dsyou.movierating.rating.domain.RateFactory;
import pl.dsyou.movierating.rating.domain.RateRepository;
import pl.dsyou.result.Empty;
import pl.dsyou.result.Result;

import java.math.BigDecimal;

@Service
@Transactional // todo dj new transactions ?
@RequiredArgsConstructor
public class RateAdditionHandler implements CmdHandler<RateAdditionCmd, Empty> {

    private final MovieRepository movieRepository;
    private final RateRepository rateRepository;

    @Override
    public Result<Empty> handle(RateAdditionCmd command) {
        BigDecimal rateValue = command.getRate();
        if (isValid(rateValue)) {
            movieRepository.findByUuid(command.getMovieUuid())
                    .map(movie -> {
                        Rate rate = RateFactory.of(movie.getSnapshot().getId(), rateValue);
                        rateRepository.save(rate);
                        return Result.success();
                    });
        }

        return Result.failure();
    }

    // todo dsyou RatePolicy
    private static boolean isValid(BigDecimal value) {
        BigDecimal remainder = value.remainder(BigDecimal.ONE);
        return remainder.equals(BigDecimal.ZERO);
    }
}
