package com.gfperez.edutrack.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonInclude;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StudentDTO {
    
    private Integer idStudent;

    @NotNull
    @Size(min=3,max=30)
    private String firstNames;

    @NotNull
    @Size(min=3,max=30)
    private String lastNames;

    @NotNull
    @Size(min = 8, max = 8)
    private String dni;

    @NotNull
    private LocalDate dateBirth;
}
