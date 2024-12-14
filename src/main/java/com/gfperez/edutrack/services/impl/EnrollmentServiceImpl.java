package com.gfperez.edutrack.services.impl;

import org.springframework.stereotype.Service;

import com.gfperez.edutrack.models.Enrollment;
import com.gfperez.edutrack.repositories.IEnrollmentRepo;
import com.gfperez.edutrack.repositories.IGenericRepo;
import com.gfperez.edutrack.services.IEnrollmentService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EnrollmentServiceImpl extends CRUDImpl<Enrollment,Integer> implements IEnrollmentService{

    private final IEnrollmentRepo repo;

    @Override
    protected IGenericRepo<Enrollment, Integer> getRepo() {
        return repo;
    }

}
