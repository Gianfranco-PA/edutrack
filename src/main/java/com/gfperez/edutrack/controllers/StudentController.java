package com.gfperez.edutrack.controllers;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gfperez.edutrack.dto.StudentDTO;
import com.gfperez.edutrack.models.Student;
import com.gfperez.edutrack.services.IStudentService;
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
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {

    private final IStudentService service;
    private final MapperUtil mapperUtil;

    @GetMapping
    public ResponseEntity<List<StudentDTO>> findAll() throws Exception {
        List<StudentDTO> list = mapperUtil.mapList(service.findAll(), StudentDTO.class);
        
        List<StudentDTO> sortedList = list.stream()
        .sorted(Comparator.comparing(StudentDTO::getDateBirth))
        .collect(Collectors.toList());

        return ResponseEntity.ok(sortedList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDTO> findById(@PathVariable Integer id) throws Exception {
        Student student = service.findById(id);
        return ResponseEntity.ok(mapperUtil.map(student, StudentDTO.class));
    }

    @PostMapping
    public ResponseEntity<StudentDTO> save(@Valid @RequestBody StudentDTO dto) throws Exception {
        Student student = service.save(mapperUtil.map(dto, Student.class));
        return new ResponseEntity<>(mapperUtil.map(student, StudentDTO.class), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentDTO> update(@Valid @PathVariable("id") Integer id, @RequestBody StudentDTO dto)
            throws Exception {
        Student student = service.update(id, mapperUtil.map(dto, Student.class));
        return new ResponseEntity<>(mapperUtil.map(student, StudentDTO.class), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
