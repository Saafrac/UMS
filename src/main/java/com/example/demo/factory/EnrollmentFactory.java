package com.example.demo.factory;

import com.example.demo.dto.enrollment.EnrollmentDto;
import com.example.demo.entity.Course;
import com.example.demo.entity.Enrollment;
import com.example.demo.entity.Student;
import org.springframework.stereotype.Component;

@Component
public class EnrollmentFactory {
    public Enrollment fromDto(EnrollmentDto dto, Student student, Course course) {
        return Enrollment.builder()
                .id(dto.getId())
                .student(student)
                .course(course)
                .build();
    }
}
