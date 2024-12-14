package com.gfperez.edutrack.models;

import java.time.LocalDate;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer idStudent;

    @Column(length = 30, nullable = false)
    private String firstNames;

    @Column(length = 30, nullable = false)
    private String lastNames;

    @Column(length = 8, nullable = false, unique = true)
    @Pattern(regexp = "\\d{8}")
    private String dni;

    // private Integer age;
    // Preferi usar la fecha de nacimiento
    @Column(nullable = false)
    private LocalDate dateBirth;
}
