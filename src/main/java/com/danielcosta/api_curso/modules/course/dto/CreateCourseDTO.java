package com.danielcosta.api_curso.modules.course.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

// Achei mais boa prática criar um DTO separado para validação
@Data
public class CreateCourseDTO {

    @NotBlank(message = "O nome do curso é obrigatório") // indica que o campo não pode ser nulo ou vazio
    @Size(max = 50, message = "O nome do curso deve ter no máximo 50 caracteres") // Define tamanho maximo do campo
    private String name;

    @NotBlank(message = "A categoria do curso é obrigatória")
    @Size(max = 30, message = "A categoria do curso deve ter no máximo 30 caracteres")
    private String category;

    @NotBlank(message = "O nome do professor é obrigatório")
    @Size(max = 50, message = "O nome do professor deve ter no máximo 50 caracteres")
    private String teacher;
}
