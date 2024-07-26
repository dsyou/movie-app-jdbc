package pl.dsyou.audit;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

@Slf4j
@Component
@RequiredArgsConstructor
class AuditEventConsumer {

    private final AuditEventWriter auditEventWriter;

    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    public void consumeAuditEvents(AuditEvent auditEvent) {
        auditEventWriter.persistEvent(auditEvent);
        log.info("Persisted audit event {}", auditEvent.toString());
    }
}
