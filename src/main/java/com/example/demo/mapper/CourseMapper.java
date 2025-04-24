package com.example.demo.mapper;

import com.example.demo.dto.course.CourseDto;
import com.example.demo.entity.Course;
import com.example.demo.entity.User;
import org.mapstruct.*;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface CourseMapper {

    Course toEntity(CourseDto dto);


    CourseDto toDto(Course entity);

    default User mapTeacher(Long teacherId) {
        if (teacherId == null) return null;
        User u = new User();
        u.setId(teacherId);
        return u;
    }
}
