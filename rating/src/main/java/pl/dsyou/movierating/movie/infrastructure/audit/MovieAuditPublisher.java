package pl.dsyou.movierating.movie.infrastructure.audit;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.dsyou.audit.AuditEventPublisher;
import pl.dsyou.command.Command;

import static pl.dsyou.movierating.movie.infrastructure.persistence.MovieTableNames.MOVIES;

@Component
@RequiredArgsConstructor
public class MovieAuditPublisher {

    private final AuditEventPublisher auditEventPublisher;

    public void publishAudit(Class<?> aggregateClass, String aggregateUUID, Command command) {
        auditEventPublisher.publishEvent(aggregateClass, aggregateUUID, command, MOVIES);
    }

}
