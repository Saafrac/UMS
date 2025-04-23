package com.example.demo.strategy;


import com.example.demo.entity.Course;

import java.util.List;

public interface CourseSortStrategy {
    List<Course> sort(List<Course> courses);
}
