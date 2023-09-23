package com.unimag.encuestapp.infrastructure.adapters.persistence.repositories;

import com.unimag.encuestapp.infrastructure.adapters.persistence.entities.SurveyEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

/**
 * Survey repository
 */
public interface ISurveyRepository extends ReactiveCrudRepository<SurveyEntity, Long> {
}
