package pl.dsyou.movierating.rating.application.command;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.dsyou.audit.AuditEventPublisher;
import pl.dsyou.command.CmdHandler;
import pl.dsyou.movierating.rating.domain.Rate;
import pl.dsyou.movierating.rating.domain.RateFactory;
import pl.dsyou.movierating.rating.domain.RateRepository;
import pl.dsyou.movierating.rating.infrastructure.audit.RateAuditPublisher;
import pl.dsyou.result.Body;
import pl.dsyou.result.Result;

@Slf4j
@Service
@Transactional
@AllArgsConstructor
public class RateCreationHandler implements CmdHandler<RateCreationCmd, Body> {
    private final RateRepository ratingRepository;
    private final RateAuditPublisher auditPublisher;

    @Override
    public Result<Body> handle(RateCreationCmd cmd) {
        final long movieId = cmd.getMovieId();
        Rate rate = RateFactory.of(movieId);
        ratingRepository.save(rate);
        log.info("Created movie rating with correlation to movie uuid: {}", movieId);
        auditPublisher.publishAudit(Rate.class, rate.getUuid(), cmd);
        return Result.success();
    }

}
