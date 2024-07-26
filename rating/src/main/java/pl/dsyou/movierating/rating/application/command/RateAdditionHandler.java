package pl.dsyou.movierating.rating.application.command;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.dsyou.audit.AuditEventPublisher;
import pl.dsyou.command.CmdHandler;
import pl.dsyou.movierating.movie.domain.Movie;
import pl.dsyou.movierating.movie.domain.MovieRepository;
import pl.dsyou.movierating.rating.domain.Rate;
import pl.dsyou.movierating.rating.domain.RateFactory;
import pl.dsyou.movierating.rating.domain.RateRepository;
import pl.dsyou.movierating.rating.infrastructure.audit.RateAuditPublisher;
import pl.dsyou.result.Empty;
import pl.dsyou.result.Result;

import java.math.BigDecimal;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class RateAdditionHandler implements CmdHandler<RateAdditionCmd, Empty> {

    private final MovieRepository movieRepository;
    private final RateRepository rateRepository;
    private final RateAuditPublisher auditEventPublisher;

    @Override
    public Result<Empty> handle(RateAdditionCmd cmd) {
        BigDecimal rateValue = cmd.getRate();

        Optional<Movie> byUuid = movieRepository.findMovieByUuid(cmd.getMovieUuid());
        if (byUuid.isEmpty()) {
            return Result.failure();
        }

        Rate rate = RateFactory.of(byUuid.get().getSnapshot().getId());
        Result<Empty> result = rate.addRate(rateValue);
        if (result.isSuccess()) {
            rateRepository.save(rate);
        }

        auditEventPublisher.publishAudit(Rate.class, rate.getUuid(), cmd);
        return result;
    }
}
