package com.unimag.encuestapp.infrastructure.entry_points.rest.survey.create;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * Create Survey request
 */
@Getter
@Setter
@NoArgsConstructor
public class CreateSurveyRequest {
    private String name;
    private boolean multiple;
    private String expirationAt;
    private List<String> options;
}
