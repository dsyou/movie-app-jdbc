package pl.dsyou.movierating.movie.domain.event;

import lombok.Value;
import pl.dsyou.domaindrivendesign.event.DomainEvent;

@Value
public class CreatedMovie implements DomainEvent {
    long movieId;
}
