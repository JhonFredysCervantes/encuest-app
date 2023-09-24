package com.unimag.encuestapp.infrastructure.entry_points.rest.survey.find;

import com.unimag.encuestapp.domain.model.survey.Survey;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.List;

import static com.unimag.encuestapp.domain.model.shared.constants.ExpressionsConstants.DATE_TIME_FORMAT;

/**
 * Find Survey response
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class FindSurveyResponse implements Serializable {
    private static final long serialVersionUID = -4372637598668128509L;

    private long id;
    private String name;
    private boolean multiple;
    private String createAt;
    private String expirationAt;
    private List<Option> options;

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder(toBuilder = true)
    public static class Option implements Serializable {
        private static final long serialVersionUID = -6330068045708056769L;
        private long id;
        private String name;
    }

    /**
     * Of method
     *
     * @param survey The survey
     * @return Create Survey response
     */
    public static FindSurveyResponse of(Survey survey) {
        var formatter = new SimpleDateFormat(DATE_TIME_FORMAT);
        return FindSurveyResponse.builder()
                .id(survey.getId())
                .name(survey.getName().value())
                .multiple(survey.isMultiple())
                .createAt(formatter.format(survey.getCreateAt().value()))
                .expirationAt(formatter.format(survey.getExpirationAt().value()))
                .options(survey.getOptions()
                        .stream()
                        .map(option -> Option.builder()
                                .id(option.getId())
                                .name(option.getName())
                                .build())
                        .toList())
                .build();
    }
}
