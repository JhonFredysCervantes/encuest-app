package com.unimag.encuestapp.infrastructure.adapters.persistence.entities;

import com.unimag.encuestapp.domain.model.survey.DateTimeSurvey;
import com.unimag.encuestapp.domain.model.survey.Survey;
import com.unimag.encuestapp.domain.model.survey.SurveyName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.List;

import static com.unimag.encuestapp.domain.model.shared.util.DateTimeUtil.convertToDateViaInstant;
import static com.unimag.encuestapp.domain.model.shared.util.DateTimeUtil.convertToLocalDateTimeViaInstant;
import static java.util.Objects.isNull;

/**
 * Survey entity
 * <br>
 * This class map the survey table
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table("survey")
public class SurveyEntity {
    @Id
    private Long id;
    @Column
    private String name;
    @Column
    private boolean multiple;
    @Column
    @DateTimeFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime createAt;
    @Column
    @DateTimeFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime deletedAt;
    @Column
    @DateTimeFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime expirationAt;

    /**
     * Convert survey domain to survey entity method
     *
     * @param survey The survey domain
     * @return The survey entity
     */
    public static SurveyEntity toEntity(Survey survey) {
        return SurveyEntity.builder()
                .name(survey.getName().value())
                .multiple(survey.isMultiple())
                .expirationAt(convertToLocalDateTimeViaInstant(survey.getExpirationAt().value()))
                .createAt(convertToLocalDateTimeViaInstant(survey.getCreateAt().value()))
                .deletedAt(convertToLocalDateTimeViaInstant(isNull(survey.getDeletedAt()) ? null : survey.getDeletedAt().value()))
                .build();
    }

    /**
     * Convert survey entity to survey domain method
     *
     * @param survey The survey entity
     * @return The survey domain
     */
    public static Survey toModel(SurveyEntity survey, List<OptionEntity> options) {
        return Survey.builder()
                .id(survey.getId())
                .name(new SurveyName(survey.getName()))
                .expirationAt(new DateTimeSurvey(convertToDateViaInstant(survey.getExpirationAt())))
                .multiple(survey.isMultiple())
                .createAt(new DateTimeSurvey(convertToDateViaInstant(survey.getCreateAt())))
                .deletedAt(new DateTimeSurvey(convertToDateViaInstant(survey.getDeletedAt())))
                .options(options.stream().map(OptionEntity::toModel)
                        .toList())
                .build();
    }

}
