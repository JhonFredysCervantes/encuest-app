package com.unimag.encuestapp.infrastructure.entry_points.rest.survey.findAll;

import com.unimag.encuestapp.domain.model.shared.exceptions.EncuestappError;
import com.unimag.encuestapp.domain.model.survey.findAll.FindAllSurveyComand;
import com.unimag.encuestapp.domain.model.survey.findAll.IFindAllSurvey;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

/**
 * Find All Survey controller
 */
@RestController
@Tag(name = "FindAll", description = "Test APIs for demo purpose")
public class FindAllSurveyController {
    private final IFindAllSurvey findAllSurvey;

    /**
     * Constructor
     *
     * @param findAllSurvey The find all survey use case
     */
    public FindAllSurveyController(IFindAllSurvey findAllSurvey) {
        this.findAllSurvey = findAllSurvey;
    }

    /**
     * Create Survey endpoint
     *
     * @return Stream Survey (Flux)
     */
    @Operation(description = "Find all Surveys",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(content = @Content(mediaType = "application/json")
            ))
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Surveys found",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = FindAllSurveyResponse.class))),
            @ApiResponse(responseCode = "400", description = "Bad request",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = EncuestappError.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = EncuestappError.class)))})
    @GetMapping("/surveys")
    public ResponseEntity<Flux<FindAllSurveyResponse>> findAll() {
        return ResponseEntity.ok(findAllSurvey.findAll(new FindAllSurveyComand())
                .map(FindAllSurveyResponse::of));
    }
}
