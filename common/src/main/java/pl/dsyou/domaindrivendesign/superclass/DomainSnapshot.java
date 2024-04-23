package pl.dsyou.domaindrivendesign.superclass;

import java.time.LocalDateTime;

public interface DomainSnapshot {
    long getId();

    String getUuid();

    default LocalDateTime getSnapshotCreatedAt() {
        return LocalDateTime.now();
    }
}
