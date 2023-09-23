package com.unimag.encuestapp.domain.model.survey;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Survey domain
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Survey {
    private long id;
    private SurveyName name;
    private boolean multiple;
    private DateTimeSurvey createAt;
    private DateTimeSurvey deletedAt;
    private DateTimeSurvey expirationAt;
}
