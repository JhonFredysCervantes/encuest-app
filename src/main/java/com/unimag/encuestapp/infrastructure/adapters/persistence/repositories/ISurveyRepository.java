package com.unimag.encuestapp.infrastructure.adapters.persistence.repositories;

import com.unimag.encuestapp.infrastructure.adapters.persistence.entities.SurveyEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Survey repository
 */
@Repository
public interface ISurveyRepository extends ReactiveCrudRepository<SurveyEntity, Long> {
}
