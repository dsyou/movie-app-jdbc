package pl.dsyou.movierating.movie.domain;

import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Embedded;
import org.springframework.data.relational.core.mapping.Table;
import pl.dsyou.domaindrivendesign.annotation.AggregateRoot;
import pl.dsyou.domaindrivendesign.entity.AggregateRootAbstract;

import java.time.LocalDate;

import static lombok.AccessLevel.PACKAGE;
import static pl.dsyou.movierating.movie.infrastructure.persistence.MovieTableNames.MOVIES;

@AggregateRoot
@Table(MOVIES)
@NoArgsConstructor(access = PACKAGE)
@EqualsAndHashCode(callSuper = false)
public class Movie extends AggregateRootAbstract {
    @Id
    private long id;

    @Embedded.Empty
    private Description description;

    Movie(String title,
          String genre,
          LocalDate productionDate) {

         createDescription(title, genre, productionDate);
    }

    public void createDescription(String title, String genre, LocalDate productionDate){
        this.description = new Description(title, genre, productionDate);
    }

    public MovieSnapshot getSnapshot(){
        return new MovieSnapshot(
                this.id,
                new MovieSnapshot.Description(
                        this.description.getTitle(),
                        this.description.getGenre(),
                        this.description.getProductionDate()
                )
        );
    }

}
