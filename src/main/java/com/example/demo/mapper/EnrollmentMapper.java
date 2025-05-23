package com.example.demo.mapper;

import com.example.demo.dto.enrollment.EnrollmentDto;
import com.example.demo.entity.Enrollment;
import com.example.demo.entity.Student;
import com.example.demo.entity.Course;
import org.mapstruct.*;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface EnrollmentMapper {

    Enrollment toEntity(EnrollmentDto dto);

    EnrollmentDto toDto(Enrollment entity);

    default Student mapStudent(Long studentId) {
        if (studentId == null) return null;
        Student s = new Student();
        s.setId(studentId);
        return s;
    }

    default Course mapCourse(Long courseId) {
        if (courseId == null) return null;
        Course c = new Course();
        c.setId(courseId);
        return c;
    }
}
