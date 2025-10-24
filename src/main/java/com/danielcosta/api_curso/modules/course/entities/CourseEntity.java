package com.danielcosta.api_curso.modules.course.entities;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // Lombok para gerar getters, setters, toString, equals e hashCode
      // automaticamente
@Entity(name = "courses") // JPA para indicar que a classe é uma entidade e o nome da tabela no banco de
                          // dados
@Builder // Lombok para criar o padrao de projeto Builder
@AllArgsConstructor // Lombok para gerar construtor com todos os argumentos
@NoArgsConstructor // Lombok para gerar construtor sem argumentos
public class CourseEntity {

    @Id // JPA para identificar chave primaria
    @GeneratedValue(strategy = GenerationType.UUID) // JPA para gerar valor automaticamente
    private UUID id;

    private String name;
    private String category;
    private String teacher;
    private boolean active;

    @CreationTimestamp // Hibernate seta data de criação automaticamente
    private LocalDateTime created_at;

    @UpdateTimestamp // Hibernate seta data de atualização automaticamente
    private LocalDateTime updated_at;
}
