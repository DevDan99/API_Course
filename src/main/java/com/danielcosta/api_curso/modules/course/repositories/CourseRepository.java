package com.danielcosta.api_curso.modules.course.repositories;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.danielcosta.api_curso.modules.course.entities.CourseEntity;

public interface CourseRepository extends JpaRepository<CourseEntity, UUID> {

    Optional<CourseEntity> findByName(String name);

    List<CourseEntity> findAll();

    List<CourseEntity> findByNameContainingIgnoreCase(String name);

    List<CourseEntity> findByCategoryContainingIgnoreCase(String category);

    List<CourseEntity> findByNameContainingIgnoreCaseOrCategoryContainingIgnoreCase(String name, String category);
}
