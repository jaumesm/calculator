package com.camaiot.calculator.web.model;

import java.util.Arrays;
import java.util.List;

public class ErrorResponse {

    private List<String> errors;

    public ErrorResponse(List<String> errors) {
        this.errors = errors;
    }

    public ErrorResponse(String error) {
        this.errors = Arrays.asList(error);
    }

    public List<String> getErrors() {
        return errors;
    }

}
