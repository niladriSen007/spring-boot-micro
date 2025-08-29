package com.niladri.product_service.advices;

import java.time.LocalDateTime;
import java.util.Map;

import org.springframework.http.HttpStatus;

import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class ErrorResponse {
    private String message;
    private HttpStatus statusCode;
    private LocalDateTime timestamp;
    private Map<String, String> subErrors;

}
