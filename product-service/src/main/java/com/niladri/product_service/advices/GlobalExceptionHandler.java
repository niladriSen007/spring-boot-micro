package com.niladri.product_service.advices;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.niladri.product_service.exceptions.ProductAlreadyExistsException;
import com.niladri.product_service.exceptions.ProductNotFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(ProductNotFoundException.class)
  public ResponseEntity<ApiResponse<?>> handleProductNotFound(ProductNotFoundException ex) {
    ErrorResponse response = ErrorResponse.builder().message(ex.getMessage()).statusCode(HttpStatus.NOT_FOUND).build();
    return buildErrorResponse(response);
  }

  @ExceptionHandler(ProductAlreadyExistsException.class)
  public ResponseEntity<ApiResponse<?>> handleProductAlreadyExists(ProductAlreadyExistsException ex) {
    ErrorResponse response = ErrorResponse.builder().message(ex.getMessage()).statusCode(HttpStatus.CONFLICT).build();
    return buildErrorResponse(response);
  }

  private ResponseEntity<ApiResponse<?>> buildErrorResponse(ErrorResponse errorResponse) {
    return new ResponseEntity<>(new ApiResponse<>(errorResponse.getMessage(), errorResponse.getStatusCode(), null),
        errorResponse.getStatusCode());
  }

}
