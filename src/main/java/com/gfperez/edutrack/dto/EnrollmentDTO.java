package com.gfperez.edutrack.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EnrollmentDTO {

    private Integer idEnrollment;

    @NotNull
    private LocalDateTime enrollmentDate;

    @NotNull
    @JsonIncludeProperties(value = {"idStudent"})
    private StudentDTO student;

    @NotNull
    @JsonManagedReference
    private List<EnrollmentDetailDTO> details;

    @NotNull
    private Boolean state;
}
