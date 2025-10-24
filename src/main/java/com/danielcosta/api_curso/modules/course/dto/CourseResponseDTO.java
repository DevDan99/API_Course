package com.danielcosta.api_curso.modules.course.dto;

import java.time.LocalDateTime;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CourseResponseDTO {
    private UUID id;
    private String name;
    private String category;
    private String teacher;
    private boolean active;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
