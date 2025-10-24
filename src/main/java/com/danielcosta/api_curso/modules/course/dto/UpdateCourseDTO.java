package com.danielcosta.api_curso.modules.course.dto;

import lombok.Data;

// Usando o DTO separado para atualização, sem validações obrigatórias, dessa forma se o usuário passar o active no body, ele não será considerado na atualização.
@Data
public class UpdateCourseDTO {
    private String name;
    private String category;
    private String teacher;
}
