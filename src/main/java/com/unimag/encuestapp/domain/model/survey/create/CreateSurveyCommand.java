package com.unimag.encuestapp.domain.model.survey.create;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * Create Survey command
 */
@Getter
@Setter
@NoArgsConstructor
public class CreateSurveyCommand {
    private String name;
    private boolean multiple;
    private String expirationAt;
    private List<String> options;
}
