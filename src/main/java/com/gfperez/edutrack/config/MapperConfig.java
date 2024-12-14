package com.gfperez.edutrack.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.gfperez.edutrack.dto.CourseDTO;
import com.gfperez.edutrack.models.Course;

@Configuration
public class MapperConfig {

    @Bean("defaultMapper")
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }

    @Bean("courseMapper")
    public ModelMapper courseMapper(){
        ModelMapper mapper = new ModelMapper();

        mapper.createTypeMap(Course.class, CourseDTO.class)
                .addMapping(Course::getState, (dest,v)-> dest.setIsActive((Boolean) v));

        mapper.createTypeMap(CourseDTO.class, Course.class)
                .addMapping(e-> e.getIsActive(), (dest,v)-> dest.setState((Boolean) v));

        return mapper;
    }
}
