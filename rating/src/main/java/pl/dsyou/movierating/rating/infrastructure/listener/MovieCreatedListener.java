package pl.dsyou.movierating.rating.infrastructure.listener;

import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;
import pl.dsyou.movierating.movie.domain.event.CreatedMovie;
import pl.dsyou.movierating.rating.application.command.RateCreationCmd;
import pl.dsyou.movierating.rating.application.command.RateCreationHandler;

@Service
@RequiredArgsConstructor
@Transactional(propagation = Propagation.REQUIRES_NEW)
class MovieCreatedListener {

    private final RateCreationHandler creationHandler;

    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    void createdMovieMovie(CreatedMovie createdMovie) {
        creationHandler.handle(new RateCreationCmd(createdMovie.getMovieId()));
    }

}
