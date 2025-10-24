package com.danielcosta.api_curso.modules.course.useCases;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.danielcosta.api_curso.exceptions.NotFoundCourseException;
import com.danielcosta.api_curso.modules.course.dto.UpdateCourseDTO;
import com.danielcosta.api_curso.modules.course.entities.CourseEntity;
import com.danielcosta.api_curso.modules.course.repositories.CourseRepository;

@Service
public class UpdateCourseUseCase {

    @Autowired
    private CourseRepository courseRepository;

    public CourseEntity execute(UUID id, UpdateCourseDTO dto) {
        // busca o curso pelo ID no banco de dados
        CourseEntity course = this.courseRepository.findById(id).orElseThrow(
                () -> new NotFoundCourseException("Curso não encontrado"));

        // atualiza os campos do curso com os valores do DTO, se não forem nulos
        // se forem nulos, mantém os valores atuais
        if (dto.getName() != null)
            course.setName(dto.getName());
        if (dto.getCategory() != null)
            course.setCategory(dto.getCategory());
        if (dto.getTeacher() != null)
            course.setTeacher(dto.getTeacher());

        return this.courseRepository.save(course);
    }

}
