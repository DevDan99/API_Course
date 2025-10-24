package com.danielcosta.api_curso.modules.course.useCases;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.danielcosta.api_curso.modules.course.dto.CourseResponseDTO;
import com.danielcosta.api_curso.modules.course.entities.CourseEntity;
import com.danielcosta.api_curso.modules.course.repositories.CourseRepository;

@Service
public class GetCourseUseCase {

    @Autowired
    private CourseRepository courseRepository;

    // Permite filtrar cursos por nome e categoria (opcionais)
    public List<CourseResponseDTO> execute(String name, String category) {
        List<CourseEntity> entities;

        // verifica qual metodo do Repository usar.
        if (name != null && category != null) {
            entities = this.courseRepository.findByNameContainingIgnoreCaseOrCategoryContainingIgnoreCase(name,
                    category);
        } else if (name != null) {
            entities = this.courseRepository.findByNameContainingIgnoreCase(name);
        } else if (category != null) {
            entities = this.courseRepository.findByCategoryContainingIgnoreCase(category);
        } else {
            entities = this.courseRepository.findAll();
        }

        // Cria uma lista de objetos do tipo CourseResponseDTO usando o build da classe.
        // Usa Stream para mapear cada CourseEntity para CourseResponseDTO
        var response = entities.stream()
                .map(course -> CourseResponseDTO.builder()
                        .id(course.getId())
                        .name(course.getName())
                        .category(course.getCategory())
                        .teacher(course.getTeacher())
                        .active(course.isActive())
                        .createdAt(course.getCreated_at())
                        .updatedAt(course.getUpdated_at())
                        .build())
                .collect(Collectors.toList());

        return response;
    }
}
