package com.gfperez.edutrack.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gfperez.edutrack.dto.CourseDTO;
import com.gfperez.edutrack.models.Course;
import com.gfperez.edutrack.services.ICourseService;
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
@RequestMapping("/courses")
@RequiredArgsConstructor
public class CourseController {

    private final ICourseService service;
    private final MapperUtil mapperUtil;

    @GetMapping
    public ResponseEntity<List<CourseDTO>> findAll() throws Exception {
        List<CourseDTO> list = mapperUtil.mapList(service.findAll(), CourseDTO.class, "courseMapper");
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CourseDTO> findById(@PathVariable Integer id) throws Exception {
        Course course = service.findById(id);
        return ResponseEntity.ok(mapperUtil.map(course, CourseDTO.class, "courseMapper"));
    }

    @PostMapping
    public ResponseEntity<CourseDTO> save(@Valid @RequestBody CourseDTO dto) throws Exception {
        Course course = service.save(mapperUtil.map(dto, Course.class, "courseMapper"));
        return new ResponseEntity<>(mapperUtil.map(course, CourseDTO.class,"courseMapper"), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CourseDTO> update(@Valid @PathVariable("id") Integer id, @RequestBody CourseDTO dto)
            throws Exception {
        Course course = service.update(id, mapperUtil.map(dto, Course.class, "courseMapper"));
        return new ResponseEntity<>(mapperUtil.map(course, CourseDTO.class), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
