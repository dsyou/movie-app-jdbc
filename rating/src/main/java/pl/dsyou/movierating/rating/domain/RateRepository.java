package pl.dsyou.movierating.rating.domain;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.dsyou.domaindrivendesign.annotation.DomainRepository;

@DomainRepository
public interface RateRepository extends CrudRepository<Rate, Long> {
}
