package com.danielcosta.api_curso.exceptions;

public class NotFoundCourseException extends RuntimeException {

    public NotFoundCourseException(String message) {
        super(message);
    }
}
