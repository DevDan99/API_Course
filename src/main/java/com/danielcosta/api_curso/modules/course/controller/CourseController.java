package com.danielcosta.api_curso.modules.course.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.danielcosta.api_curso.modules.course.dto.CourseResponseDTO;
import com.danielcosta.api_curso.modules.course.dto.CreateCourseDTO;
import com.danielcosta.api_curso.modules.course.dto.UpdateCourseDTO;
import com.danielcosta.api_curso.modules.course.useCases.CreateCourseUseCase;
import com.danielcosta.api_curso.modules.course.useCases.DeleteCourseUseCase;
import com.danielcosta.api_curso.modules.course.useCases.GetCourseUseCase;
import com.danielcosta.api_curso.modules.course.useCases.PatchCourseUseCase;
import com.danielcosta.api_curso.modules.course.useCases.UpdateCourseUseCase;

import jakarta.validation.Valid;

@RestController // Seta classe como um controlador REST
@RequestMapping("/cursos") // Mapeia requisições para /
public class CourseController {

    @Autowired // Injeta e gerencia a dependência automaticamente
    private CreateCourseUseCase createCourseUseCase;

    @Autowired
    private GetCourseUseCase getCourseUseCase;

    @Autowired
    private UpdateCourseUseCase updateCourseUseCase;

    @Autowired
    private DeleteCourseUseCase deleteCourseUseCase;

    @Autowired
    private PatchCourseUseCase patchCourseUseCase;

    @PostMapping // Indica que metodo POST possui esse endpoint. Rota: localhost:8080/cursos
    public ResponseEntity<Object> create(@Valid @RequestBody CreateCourseDTO course) {

        try {
            var result = this.createCourseUseCase.execute(course);
            return ResponseEntity.ok().body(result);

        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping // Indica que metodo GET possui esse endpoint. Rota: localhost:8080/cursos
    public ResponseEntity<Object> getCourses(
            // Parametros opcionais para filtro
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String category) {

        try {
            List<CourseResponseDTO> result = this.getCourseUseCase.execute(name, category);
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}") // Indica que metodo PUT possui esse endpoint. Rota: localhost:8080/cursos/{id}
    public ResponseEntity<Object> update(@PathVariable UUID id, @RequestBody UpdateCourseDTO update) {
        try {
            var result = this.updateCourseUseCase.execute(id, update);
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}") // Indica que metodo DELETE possui esse endpoint. Rota:
                            // localhost:8080/cursos/{id}
    public ResponseEntity<Object> delete(@PathVariable UUID id) {
        try {
            var result = this.deleteCourseUseCase.execute(id);
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PatchMapping("/{id}/active")
    public ResponseEntity<Object> toggleActivate(@PathVariable UUID id) {
        try {
            var result = this.patchCourseUseCase.execute(id);
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
