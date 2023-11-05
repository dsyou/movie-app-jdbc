package pl.dsyou.movierating.movie.view;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.ReadOnlyProperty;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;
import java.util.Date;

import static pl.dsyou.movierating.movie.infrastructure.persistence.MovieTableNames.MOVIE;

@Table(MOVIE)
@Getter
@AllArgsConstructor
public class MovieView {
    @Id
    @JsonIgnore
    private final long id;
    @ReadOnlyProperty
    private final String uuid;
    @ReadOnlyProperty
    private final String title;
    @ReadOnlyProperty
    private final String genre;
    @ReadOnlyProperty
    private final LocalDateTime productionDate;
}
