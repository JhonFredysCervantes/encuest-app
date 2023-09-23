package com.unimag.encuestapp.infrastructure.adapters.persistence.repositories;

import com.unimag.encuestapp.infrastructure.adapters.persistence.entities.OptionEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

/**
 * Option survey repository
 */
@Repository
public interface IOptionSurveyRepository extends ReactiveCrudRepository<OptionEntity, Long> {

    /**
     * Find all by survey id method
     *
     * @param surveyId The survey id
     * @return The option entity flux
     */
    Flux<OptionEntity> findAllBySurveyId(Long surveyId);
}
