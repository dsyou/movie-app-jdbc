package pl.dsyou.movierating.movie.view;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.ReadOnlyProperty;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;

import static pl.dsyou.movierating.movie.infrastructure.persistence.MovieTableNames.MOVIES;

@Table(MOVIES)
@Getter
@NoArgsConstructor(access = AccessLevel.PACKAGE)
class MovieView {
    @Id
    private long id;
    @ReadOnlyProperty
    private String uuid;
    @ReadOnlyProperty
    private String title;
    @ReadOnlyProperty
    private String genre;
    @ReadOnlyProperty
    private LocalDate productionDate;
}
