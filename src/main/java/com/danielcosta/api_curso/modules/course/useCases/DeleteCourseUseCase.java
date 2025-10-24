package com.danielcosta.api_curso.modules.course.useCases;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.danielcosta.api_curso.exceptions.NotFoundCourseException;
import com.danielcosta.api_curso.modules.course.repositories.CourseRepository;

@Service
public class DeleteCourseUseCase {
    @Autowired
    private CourseRepository courseRepository;

    // Recebe o ID do curso a ser deletado e retorna uma mensagem de sucesso
    public String execute(UUID id) {
        // Verifica se o curso existe
        this.courseRepository.findById(id).orElseThrow(
                () -> new NotFoundCourseException("Curso não encontrado!"));

        this.courseRepository.deleteById(id);
        return "Curso com ID " + id + " foi deletado com sucesso";
    }
}
