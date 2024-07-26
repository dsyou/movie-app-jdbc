package pl.dsyou.movierating.rating.infrastructure.audit;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.dsyou.audit.AuditEventPublisher;
import pl.dsyou.command.Command;

import static pl.dsyou.movierating.rating.infrastructure.persistence.RatingTableNames.RATES;

@Component
@RequiredArgsConstructor
public class RateAuditPublisher {

    private final AuditEventPublisher auditEventPublisher;

    public void publishAudit(Class<?> aggregateClass, String aggregateUUID, Command command) {
        auditEventPublisher.publishEvent(aggregateClass, aggregateUUID, command, RATES);
    }
}
