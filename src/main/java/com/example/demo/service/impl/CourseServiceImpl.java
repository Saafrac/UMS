package com.example.demo.service.impl;

import com.example.demo.dto.course.CourseDto;
import com.example.demo.entity.Course;
import com.example.demo.mapper.CourseMapper;
import com.example.demo.repository.CourseRepository;
import com.example.demo.service.CourseService;
import com.example.demo.strategy.CourseSortStrategy;
import com.example.demo.strategy.CourseSorter;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.*;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {
    private final CourseRepository repo;
    private final CourseMapper mapper;
    private final CourseSorter sorter;

    @Override
    public CourseDto create(CourseDto dto) {
        Course c = mapper.toEntity(dto);
        return mapper.toDto(repo.save(c));
    }

    @Override
    public CourseDto getById(Long id) {
        Course c = repo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Course not found"));
        return mapper.toDto(c);
    }

    @Override
    public List<CourseDto> getAll(String sortBy) {
        List<Course> list = repo.findAll();
        CourseSortStrategy strategy = sorter.getStrategy(sortBy);
        List<Course> sorted = strategy.sort(list);
        return sorted.stream().map(mapper::toDto).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public CourseDto update(Long id, CourseDto dto) {
        Course exist = repo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Course not found"));
        exist.setTitle(dto.getTitle());
        exist.setDescription(dto.getDescription());
        exist.setStartDate(dto.getStartDate());
        return mapper.toDto(repo.save(exist));
    }

    @Override
    @Transactional
    public void delete(Long id) {
        repo.deleteById(id);
    }
}
