package com.example.demo.strategy;


import com.example.demo.entity.Course;
import org.springframework.stereotype.Component;
import java.util.*;
import java.util.stream.*;

@Component("date")
public class ByDateStrategy implements CourseSortStrategy {
    public List<Course> sort(List<Course> c) {
        return c.stream()
                .sorted(Comparator.comparing(Course::getStartDate))
                .collect(Collectors.toList());
    }
}

