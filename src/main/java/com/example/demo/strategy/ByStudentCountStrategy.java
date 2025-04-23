package com.example.demo.strategy;

import com.example.demo.entity.Course;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Component("count")
public class ByStudentCountStrategy implements CourseSortStrategy {
    @Override
    public List<Course> sort(List<Course> courses) {
        return courses.stream()
                .sorted(Comparator.comparingInt(course -> course.getEnrollments().size()))
                .collect(Collectors.toList());
    }
}