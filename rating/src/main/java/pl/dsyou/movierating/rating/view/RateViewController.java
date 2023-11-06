package pl.dsyou.movierating.rating.view;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.dsyou.movierating.movie.view.MovieViewRepository;

import java.math.BigDecimal;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("rates")
@RequiredArgsConstructor
class RateViewController {

    private final RateViewRepository rateViewRepository;
    private final MovieViewRepository movieViewRepository;

    @GetMapping("/{movieUuid}")
    @ResponseStatus(OK)
    public BigDecimal getRateAvg(@PathVariable(name = "movieUuid") String movieUuid) {
        return movieViewRepository.findByUuid(movieUuid)
                .map(movie -> rateViewRepository.avgRateToTwoRound(movie.getId()))
                .orElseThrow();// todo dsyou create Factory exception's
    }
}
