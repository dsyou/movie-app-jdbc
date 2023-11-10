package pl.dsyou.movierating.rating.infrastructure.listener;

import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import pl.dsyou.movierating.movie.domain.event.CreatedMovie;
import pl.dsyou.movierating.rating.application.command.RateCreationCmd;
import pl.dsyou.movierating.rating.application.command.RateCreationHandler;

@Component
@RequiredArgsConstructor
class MovieCreatedListener {

    private final RateCreationHandler creationHandler;

    @Async
    @EventListener
    void createdMovieMovie(CreatedMovie createdMovie) {
        creationHandler.handle(new RateCreationCmd(createdMovie.getMovieId()));

    }

}
