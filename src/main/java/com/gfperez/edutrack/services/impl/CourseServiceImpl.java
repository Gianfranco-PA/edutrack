package com.gfperez.edutrack.services.impl;

import org.springframework.stereotype.Service;

import com.gfperez.edutrack.models.Course;
import com.gfperez.edutrack.repositories.ICourseRepo;
import com.gfperez.edutrack.repositories.IGenericRepo;
import com.gfperez.edutrack.services.ICourseService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl extends CRUDImpl<Course, Integer> implements ICourseService{

    private final ICourseRepo repo;

    @Override
    protected IGenericRepo<Course, Integer> getRepo() {
        return repo;
    }

    

}
