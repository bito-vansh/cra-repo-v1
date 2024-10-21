package com.demo.cra.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.http.HttpStatus;

/**
 * A generic response data transfer object (DTO) for API responses.
 * This class encapsulates the response data, success status, message, and HTTP status.
 * The HTTP status is ignored during JSON serialization.
 *
 * @param <T> The type of data contained in the response
 */
public class ResponseDtoV1<T> {

    private T data;

    private Boolean success;

    private String message;

    @JsonIgnore
    private HttpStatus httpStatus;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

}
