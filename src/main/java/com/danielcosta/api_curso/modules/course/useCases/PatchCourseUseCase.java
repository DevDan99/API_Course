package com.danielcosta.api_curso.modules.course.useCases;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.danielcosta.api_curso.exceptions.NotFoundCourseException;
import com.danielcosta.api_curso.modules.course.entities.CourseEntity;
import com.danielcosta.api_curso.modules.course.repositories.CourseRepository;

@Service
public class PatchCourseUseCase {

    @Autowired
    private CourseRepository courseRepository;

    public String execute(UUID id) {
        CourseEntity course = this.courseRepository.findById(id).orElseThrow(
                () -> new NotFoundCourseException("Nenhum curso encontrado com este ID"));

        course.setActive(!course.isActive());
        this.courseRepository.save(course);
        return "Curso com ID " + course.getId() + " foi " +
                (course.isActive() ? "ativado" : "desativado") + " com sucesso";
    }
}
