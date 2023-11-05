package pl.dsyou.movierating.rating.view;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("rates")
@RequiredArgsConstructor
class RateViewController {

    private final RateViewRepository rateViewRepository;

    @GetMapping
    @ResponseStatus(OK)
    public void getRateAvg() {

    }
}
