package pl.dsyou.movierating.rating.view;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.dsyou.exception.ElementNotFoundException;
import pl.dsyou.movierating.movie.view.MovieViewRepository;

import java.math.BigDecimal;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/api/v1/rates")
@RequiredArgsConstructor
class RateViewController {

    private final RateViewRepository rateViewRepository;
    private final MovieViewRepository movieViewRepository;

    @GetMapping("/{movieUuid}")
    @ResponseStatus(OK)
    public BigDecimal getRateAvg(@PathVariable(name = "movieUuid") String movieUuid) {
        return movieViewRepository.findByUuid(movieUuid)
                .map(movie -> rateViewRepository.avgRateToTwoRound(movie.getId()))
                .orElseThrow(() -> new ElementNotFoundException(String.format("Movie with uuid: %s doesn't exists", movieUuid)));
    }
}
