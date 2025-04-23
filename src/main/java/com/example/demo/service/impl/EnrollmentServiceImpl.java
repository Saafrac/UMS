package com.example.demo.service.impl;


import com.example.demo.dto.enrollment.EnrollmentDto;
import com.example.demo.entity.Enrollment;
import com.example.demo.mapper.EnrollmentMapper;
import com.example.demo.repository.EnrollmentRepository;
import com.example.demo.service.EnrollmentService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class EnrollmentServiceImpl implements EnrollmentService {
    private final EnrollmentRepository repo;
    private final EnrollmentMapper mapper;

    @Override
    public EnrollmentDto create(EnrollmentDto dto) {
        Enrollment e = mapper.toEntity(dto);
        return mapper.toDto(repo.save(e));
    }

    @Override
    public EnrollmentDto getById(Long id) {
        Enrollment e = repo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Enrollment not found"));
        return mapper.toDto(e);
    }

    @Override
    public List<EnrollmentDto> getAll() {
        List<Enrollment> list = repo.findAll();
        List<EnrollmentDto> dtos = new ArrayList<>();
        for (Enrollment e: list) dtos.add(mapper.toDto(e));
        return dtos;
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }
}
