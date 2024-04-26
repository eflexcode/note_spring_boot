package com.ifeanyi.note.exception.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class ErrorResponse {

    private Integer statusCode;
    private String message;
    private Date timestamp;

}
