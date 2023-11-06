package pl.dsyou.movierating.movie.view;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.ReadOnlyProperty;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;

import static pl.dsyou.movierating.movie.infrastructure.persistence.MovieTableNames.MOVIES;

@Table(MOVIES)
@Getter
@AllArgsConstructor
public class MovieView {
    @Id
    private final long id;
    @ReadOnlyProperty
    private final String uuid;
    @ReadOnlyProperty
    private final String title;
    @ReadOnlyProperty
    private final String genre;
    @ReadOnlyProperty
    private final LocalDate productionDate;
}
