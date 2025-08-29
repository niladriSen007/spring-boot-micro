package com.niladri.product_service.advices;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import lombok.Data;

@Data
public class ApiResponse<T> {
  private T data;
  private String message;
  private HttpStatus statusCode;
  private LocalDateTime timeStamp;
  private ErrorResponse errorResponse;

  public ApiResponse() {
    this.timeStamp = LocalDateTime.now();
  }

  public ApiResponse(String message, HttpStatus statusCode, T data) {
    this();
    this.data = data;
    this.message = message;
    this.statusCode = statusCode;
  }

  public ApiResponse(ErrorResponse errorResponse) {
    this();
    this.errorResponse = errorResponse;
  }

}
