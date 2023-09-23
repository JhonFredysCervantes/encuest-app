package com.unimag.encuestapp.domain.model.shared.exceptions;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * Encuestapp error
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class EncuestappError implements Serializable {
    private static final long serialVersionUID = 2595370812262530931L;
    private String code;
    private String exception;
    private String message;
    private String detail;
}
