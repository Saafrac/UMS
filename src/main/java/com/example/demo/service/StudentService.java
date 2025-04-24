package com.example.demo.service;


import com.example.demo.dto.student.StudentDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
public interface StudentService {
    StudentDto create(StudentDto dto);
    StudentDto getById(Long id);
    Page<StudentDto> getAll(String name, String major, Pageable pageable);
    StudentDto update(Long id, StudentDto dto);
    void delete(Long id);
}