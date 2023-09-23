package com.unimag.encuestapp.infrastructure.adapters.persistence.entities;

import com.unimag.encuestapp.domain.model.survey.Option;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

/**
 * Option entity
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table("option")
public class OptionEntity {
    @Id
    private Long id;
    @Column
    private String name;
    @Column
    private Long surveyId;

    /**
     * Convert option domain to option entity method
     *
     * @param option The option domain
     * @return The option entity
     */
    public static Option toModel(OptionEntity option) {
        return Option.builder()
                .id(option.getId())
                .name(option.getName())
                .build();
    }

}
