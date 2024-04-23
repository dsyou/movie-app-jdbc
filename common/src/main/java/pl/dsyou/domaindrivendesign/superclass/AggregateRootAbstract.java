package pl.dsyou.domaindrivendesign.superclass;

import lombok.Getter;
import org.springframework.data.domain.AfterDomainEventPublication;
import org.springframework.data.domain.DomainEvents;
import pl.dsyou.domaindrivendesign.event.DomainEvent;

import java.util.*;

import static lombok.AccessLevel.PUBLIC;

public abstract class AggregateRootAbstract {

    @Getter(PUBLIC)
    protected String uuid;

    private final List<DomainEvent> events = new ArrayList<>();

//    public AggregateRootAbstract() {
//        this.uuid = UUID.randomUUID().toString();
//    }

    protected void addEvent(DomainEvent domainEvent) {
        this.events.add(domainEvent);
    }

    @DomainEvents
    private Collection<DomainEvent> publishEvents() {
        return Collections.unmodifiableList(this.events);
    }

    @AfterDomainEventPublication
    private void cleanUpEvents() {
        this.events.clear();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AggregateRootAbstract that = (AggregateRootAbstract) o;
        return Objects.equals(uuid, that.uuid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid);
    }
}
