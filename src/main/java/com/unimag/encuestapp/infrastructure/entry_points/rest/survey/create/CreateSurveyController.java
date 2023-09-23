package com.unimag.encuestapp.infrastructure.entry_points.rest.survey.create;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.unimag.encuestapp.domain.model.shared.exceptions.EncuestappError;
import com.unimag.encuestapp.domain.model.survey.create.CreateSurveyCommand;
import com.unimag.encuestapp.domain.model.survey.create.ICreateSurvey;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.net.URI;

/**
 * Create Survey controller
 */
@RestController
@Tag(name = "Create", description = "Test APIs for demo purpose")
public class CreateSurveyController {
    private final ICreateSurvey createSurvey;
    private final ObjectMapper objectMapper;

    /**
     * Constructor
     *
     * @param createSurvey The Create Survey use case
     * @param objectMapper The object mapper
     */
    public CreateSurveyController(ICreateSurvey createSurvey, ObjectMapper objectMapper) {
        this.createSurvey = createSurvey;
        this.objectMapper = objectMapper;
    }

    /**
     * Create Survey endpoint
     *
     * @param request The Create Survey request
     * @return Stream Survey (Mono)
     */
    @Operation(description = "Create Survey",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(content =
            @Content(mediaType = "application/json", schema = @Schema(implementation = CreateSurveyRequest.class))
            ))
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Survey created",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = CreateSurveyResponse.class))),
            @ApiResponse(responseCode = "400", description = "Bad request",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = EncuestappError.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = EncuestappError.class)))})
    @PostMapping("/survey")
    public Mono<ResponseEntity<CreateSurveyResponse>> create(@RequestBody CreateSurveyRequest request) {
        var createSurveyCommand = objectMapper.convertValue(request, CreateSurveyCommand.class);
        return createSurvey.create(createSurveyCommand)
                .map(CreateSurveyResponse::of)
                .map(response -> ResponseEntity.created(URI.create("/survey/" + response.getId())).body(response));
    }
}
