package com.gfperez.edutrack.controllers;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gfperez.edutrack.dto.EnrollmentDTO;
import com.gfperez.edutrack.dto.EnrollmentDetailDTO;
import com.gfperez.edutrack.models.Enrollment;
import com.gfperez.edutrack.services.IEnrollmentService;
import com.gfperez.edutrack.util.MapperUtil;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/enrollments")
@RequiredArgsConstructor
public class EnrollmentController {

    private final IEnrollmentService service;
    private final MapperUtil mapperUtil;

    @GetMapping
    public ResponseEntity<List<EnrollmentDTO>> findAll() throws Exception {
        List<EnrollmentDTO> list = mapperUtil.mapList(service.findAll(), EnrollmentDTO.class);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EnrollmentDTO> findById(@PathVariable Integer id) throws Exception {
        Enrollment enrollment = service.findById(id);
        return ResponseEntity.ok(mapperUtil.map(enrollment, EnrollmentDTO.class));
    }

    @PostMapping
    public ResponseEntity<EnrollmentDTO> save(@Valid @RequestBody EnrollmentDTO dto) throws Exception {
        Enrollment enrollment = service.save(mapperUtil.map(dto, Enrollment.class));
        return new ResponseEntity<>(mapperUtil.map(enrollment, EnrollmentDTO.class), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EnrollmentDTO> update(@Valid @PathVariable("id") Integer id, @RequestBody EnrollmentDTO dto)
            throws Exception {
        Enrollment enrollment = service.update(id, mapperUtil.map(dto, Enrollment.class));
        return new ResponseEntity<>(mapperUtil.map(enrollment, EnrollmentDTO.class), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/courses-students")
    public ResponseEntity<Map<String, List<String>>> relationsCoursesStudents() throws Exception {
        List<EnrollmentDTO> list = mapperUtil.mapList(service.findAll(), EnrollmentDTO.class);

        Stream<EnrollmentDetailDTO> streamDetails = list.stream().flatMap(enrollment-> enrollment.getDetails().stream());

        Map<String, List<String>> listCoursesStudents = streamDetails.collect(Collectors.groupingBy(
            detail-> detail.getCourse().getName(),
            Collectors.mapping(
                detail -> detail.getEnrollment().getStudent().getFirstNames() + " " + detail.getEnrollment().getStudent().getLastNames(), 
                Collectors.toList()
            )
        ));
        return ResponseEntity.ok(listCoursesStudents);
    }
    
}
