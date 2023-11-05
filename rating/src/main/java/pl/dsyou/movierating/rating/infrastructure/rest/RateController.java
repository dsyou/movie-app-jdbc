package pl.dsyou.movierating.rating.infrastructure.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.dsyou.movierating.rating.application.command.RateAdditionCmd;
import pl.dsyou.movierating.rating.application.command.RateAdditionHandler;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("rates")
@RequiredArgsConstructor
class RateController {
    private final RateAdditionHandler creationHandler;

    @PostMapping
    @ResponseStatus(CREATED)
    void addRate(@RequestBody RateAdditionCmd cmd) {
        this.creationHandler.handle(cmd);
    }

}
