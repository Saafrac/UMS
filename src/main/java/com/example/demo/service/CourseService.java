package com.example.demo.service;

import com.example.demo.dto.course.CourseDto;

import java.util.List;

public interface CourseService {
    CourseDto create(CourseDto dto);
    CourseDto getById(Long id);
    List<CourseDto> getAll(String sortBy);
    CourseDto update(Long id, CourseDto dto);
    void delete(Long id);
}