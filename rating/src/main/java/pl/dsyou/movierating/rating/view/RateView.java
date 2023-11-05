package pl.dsyou.movierating.rating.view;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.Id;

import java.math.BigDecimal;
import java.math.RoundingMode;

class RateView {

    @JsonIgnore
    @Id
    private long id;

    private long movieId;
    private float score;

    // todo dsyou
    private float round(float sumOfRanks, int decimalPlace) {
        return BigDecimal.valueOf(sumOfRanks).setScale(decimalPlace, RoundingMode.UP).floatValue();
    }

}
