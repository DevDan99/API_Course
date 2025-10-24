package com.danielcosta.api_curso.modules.course.useCases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.danielcosta.api_curso.exceptions.CourseFoundException;
import com.danielcosta.api_curso.modules.course.dto.CreateCourseDTO;
import com.danielcosta.api_curso.modules.course.entities.CourseEntity;
import com.danielcosta.api_curso.modules.course.repositories.CourseRepository;

@Service
public class CreateCourseUseCase {

    @Autowired
    private CourseRepository courseRepository;

    public CourseEntity execute(CreateCourseDTO course) {
        // Usar o Builder do lombok é melhor do que a instaciação direta, para criar o
        // objeto.
        // Converte para CourseEntity
        // Usando o padrao Builder para criar objeto
        var courseEntity = CourseEntity.builder()
                .name(course.getName())
                .category(course.getCategory())
                .teacher(course.getTeacher())
                .active(true) // Define curso como ativo por padrão
                .build();

        this.courseRepository.findByName(courseEntity.getName()).ifPresent(
                (courseName) -> {
                    throw new CourseFoundException("Curso ja cadastrado");
                });

        return this.courseRepository.save(courseEntity);
    }
}
