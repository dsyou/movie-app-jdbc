package pl.dsyou.movierating.rating.domain;

import pl.dsyou.result.Empty;
import pl.dsyou.result.Result;

import java.math.BigDecimal;
import java.util.List;

interface RatePolicy {

    static RatePolicy defaultPolicy() {
        return new CompositeRateCheck(
                List.of(
                        new IntegerRateCheck(),
                        new RangeRateCheck()
                )
        );
    }

    Result<Empty> validate(BigDecimal rate);
}

class IntegerRateCheck implements RatePolicy {
    @Override
    public Result<Empty> validate(BigDecimal rate) {
        if (isInteger(rate)) {
            return Result.failure();
        }

        return Result.success();
    }


    private boolean isInteger(BigDecimal rate) {
        BigDecimal remainder = rate.remainder(BigDecimal.ONE);
        return remainder.equals(BigDecimal.ZERO);
    }
}

class RangeRateCheck implements RatePolicy {
    @Override
    public Result<Empty> validate(BigDecimal rate) {
        if (!isRange1To10(rate)) {
            return Result.failure();
        }
        return Result.success();
    }

    private static boolean isRange1To10(BigDecimal rate) {
        BigDecimal lowerBound = new BigDecimal("1");
        BigDecimal upperBound = new BigDecimal("10");
        return rate.compareTo(lowerBound) >= 0 && rate.compareTo(upperBound) <= 0;
    }
}

class CompositeRateCheck implements RatePolicy {

    private final List<RatePolicy> ratePolicies;

    CompositeRateCheck(List<RatePolicy> ratePolicies) {
        this.ratePolicies = ratePolicies;
    }

    @Override
    public Result<Empty> validate(BigDecimal rate) {
        return this.ratePolicies.stream()
                .map(check -> check.validate(rate))
                .filter(emptyResult -> !emptyResult.isSuccess())
                .findAny()
                .orElse(Result.success());
    }
}
