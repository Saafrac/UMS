package com.example.demo.factory;


import com.example.demo.dto.course.CourseDto;
import com.example.demo.entity.Course;
import com.example.demo.entity.User;
import org.springframework.stereotype.Component;

@Component
public class CourseFactory {
    public Course fromDto(CourseDto dto, User teacher) {
        return Course.builder()
                .id(dto.getId())
                .title(dto.getTitle())
                .description(dto.getDescription())
                .startDate(dto.getStartDate())
                .teacher(teacher)
                .build();
    }
}
