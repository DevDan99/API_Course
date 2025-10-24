package com.danielcosta.api_curso.exceptions;

// Extende RuntimeException para ser uma exceção não verificada.
public class CourseFoundException extends RuntimeException {

    public CourseFoundException(String message) {
        super(message);
    }
}
