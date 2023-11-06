package pl.dsyou.movierating.rating.application.command;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.dsyou.command.CmdHandler;
import pl.dsyou.movierating.movie.view.MovieViewRepository;
import pl.dsyou.movierating.rating.domain.Rate;
import pl.dsyou.movierating.rating.domain.RateFactory;
import pl.dsyou.movierating.rating.domain.RateRepository;
import pl.dsyou.result.Empty;
import pl.dsyou.result.Result;

import java.math.BigDecimal;

@Service
@Transactional
@AllArgsConstructor
public class RateAdditionHandler implements CmdHandler<RateAdditionCmd, Empty> {

    private final MovieViewRepository movieRepository;
    private final RateRepository rateRepository;

    @Override
    public Result<Empty> handle(RateAdditionCmd command) {
        BigDecimal rateValue = command.getRate();
        if (isValid(rateValue)) {
            movieRepository.findByUuid(command.getMovieUuid())
                    .map(movie -> {
                        Rate rate = RateFactory.of(movie.getId(), rateValue);
                        rateRepository.save(rate);
                        return Result.success();
                    });
        }

        return Result.failure();
    }

    private static boolean isValid(BigDecimal value) {
        BigDecimal remainder = value.remainder(BigDecimal.ONE);
        return remainder.equals(BigDecimal.ZERO);
    }
}
