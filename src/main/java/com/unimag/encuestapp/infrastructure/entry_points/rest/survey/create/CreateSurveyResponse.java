package com.unimag.encuestapp.infrastructure.entry_points.rest.survey.create;

import com.unimag.encuestapp.domain.model.survey.Survey;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.text.SimpleDateFormat;

import static com.unimag.encuestapp.domain.model.shared.constants.ExpressionsConstants.DATE_TIME_FORMAT;

/**
 * Create Survey response
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class CreateSurveyResponse implements Serializable {
    private static final long serialVersionUID = -4372637598668128509L;

    private long id;
    private String name;
    private boolean multiple;
    private String createAt;
    private String expirationAt;

    /**
     * Of method
     *
     * @param survey The survey
     * @return Create Survey response
     */
    public static CreateSurveyResponse of(Survey survey) {
        var formatter = new SimpleDateFormat(DATE_TIME_FORMAT);
        return CreateSurveyResponse.builder()
                .id(survey.getId())
                .name(survey.getName().value())
                .multiple(survey.isMultiple())
                .createAt(formatter.format(survey.getCreateAt().value()))
                .expirationAt(formatter.format(survey.getExpirationAt().value()))
                .build();
    }
}
