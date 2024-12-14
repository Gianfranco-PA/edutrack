package com.gfperez.edutrack.services.impl;

import org.springframework.stereotype.Service;

import com.gfperez.edutrack.models.Student;
import com.gfperez.edutrack.repositories.IGenericRepo;
import com.gfperez.edutrack.repositories.IStudentRepo;
import com.gfperez.edutrack.services.IStudentService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl  extends CRUDImpl<Student,Integer> implements IStudentService{

    private final IStudentRepo repo;

    @Override
    protected IGenericRepo<Student, Integer> getRepo() {
        return repo;
    }

}
