package pl.dsyou.movierating.movie.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pl.dsyou.domaindrivendesign.annotation.AggregateRoot;
import pl.dsyou.domaindrivendesign.superclass.AggregateRootAbstract;

import java.time.LocalDate;

import static lombok.AccessLevel.PACKAGE;

@AggregateRoot
@Getter(PACKAGE)
@NoArgsConstructor(access = PACKAGE)
@EqualsAndHashCode(callSuper = false)
public class Movie extends AggregateRootAbstract {

    private long id;
    private Description description;

    public Movie(String uuid,
                 String title,
                 String genre,
                 LocalDate productionDate
    ) {
        super();
        this.uuid = uuid;
        createDescription(title, genre, productionDate);
    }

    public Movie(long id,
                 String uuid,
                 String title,
                 String genre,
                 LocalDate productionDate
    ) {
        super();
        this.id = id;
        this.uuid = uuid;
        createDescription(title, genre, productionDate);
    }

    public void createDescription(String title, String genre, LocalDate productionDate) {
        this.description = new Description(title, genre, productionDate);
    }

    public MovieSnapshot getSnapshot() {
        return new MovieSnapshotImpl(this);
    }

}
