package com.unimag.encuestapp.infrastructure.entry_points.rest.survey.find;

import com.unimag.encuestapp.domain.model.shared.exceptions.EncuestappError;
import com.unimag.encuestapp.domain.model.survey.find.FindSurveyCommand;
import com.unimag.encuestapp.domain.model.survey.find.IFindSurvey;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * Find Survey controller
 */
@RestController
@Tag(name = "Find", description = "Test APIs for demo purpose")
public class FindSurveyController {
    private final IFindSurvey findSurvey;

    /**
     * Constructor
     *
     * @param findSurvey The find survey use case
     */
    public FindSurveyController(IFindSurvey findSurvey) {
        this.findSurvey = findSurvey;
    }

    /**
     * Create Survey endpoint
     *
     * @param id The survey id
     * @return Stream Survey (Mono)
     */
    @Operation(description = "Find Survey",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(content = @Content(mediaType = "application/json")
            ))
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Survey found",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = FindSurveyResponse.class))),
            @ApiResponse(responseCode = "400", description = "Bad request",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = EncuestappError.class))),
            @ApiResponse(responseCode = "404", description = "Survey not found",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = EncuestappError.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = EncuestappError.class)))})
    @GetMapping("/surveys/{id}")
    public Mono<ResponseEntity<FindSurveyResponse>> find(@PathVariable("id") Long id) {
        return findSurvey.findById(new FindSurveyCommand(id))
                .map(FindSurveyResponse::of)
                .map(ResponseEntity::ok);
    }
}
