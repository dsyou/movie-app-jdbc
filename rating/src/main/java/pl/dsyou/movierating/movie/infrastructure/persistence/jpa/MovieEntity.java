package pl.dsyou.movierating.movie.infrastructure.persistence.jpa;

import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceCreator;
import org.springframework.data.relational.core.mapping.Embedded;
import org.springframework.data.relational.core.mapping.Table;
import pl.dsyou.movierating.movie.domain.MovieSnapshot;

import java.time.LocalDate;

import static lombok.AccessLevel.PACKAGE;
import static pl.dsyou.movierating.movie.infrastructure.persistence.MovieTableNames.MOVIES;

@Table(MOVIES)
@NoArgsConstructor(access = PACKAGE)
@EqualsAndHashCode(callSuper = false)
public class MovieEntity implements MovieSnapshot {
    @Id
    private Long id;
    private String uuid;

    @Embedded.Empty
    private DescriptionEntity description;

    MovieEntity(
                String uuid,
                String title,
                String genre,
                LocalDate productionDate) {

        this.uuid = uuid;
        createDescription(title, genre, productionDate);
    }

    public void createDescription(String title, String genre, LocalDate productionDate) {
        this.description = new DescriptionEntity(title, genre, productionDate);
    }

    @Override
    public long getId() {
        return this.id;
    }

    @Override
    public String getUuid() {
        return this.uuid;
    }

    @Override
    public String getTitle() {
        return this.description.getTitle();
    }

    @Override
    public String getGenre() {
        return this.description.getGenre();
    }

    @Override
    public LocalDate getProductionDate() {
        return this.description.getProductionDate();
    }
}
