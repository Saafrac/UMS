package com.example.demo.service;

import com.example.demo.dto.enrollment.EnrollmentDto;

import java.util.List;
public interface EnrollmentService {
    EnrollmentDto create(EnrollmentDto dto);
    EnrollmentDto getById(Long id);
    List<EnrollmentDto> getAll();
    void delete(Long id);
}