package com.example.demo.service.impl;

import com.example.demo.dto.student.StudentDto;
import com.example.demo.entity.Student;
import com.example.demo.mapper.StudentMapper;
import com.example.demo.repository.StudentRepository;
import com.example.demo.service.StudentService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.*;


@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepository repo;
    private final StudentMapper mapper;

    @Override
    public StudentDto create(StudentDto dto) {
        Student s = mapper.toEntity(dto);
        return mapper.toDto(repo.save(s));
    }

    @Override
    public StudentDto getById(Long id) {
        Student s = repo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Student not found"));
        return mapper.toDto(s);
    }

    @Override
    public List<StudentDto> getAll() {
        List<Student> list = repo.findAll();
        List<StudentDto> dtos = new ArrayList<>();
        for (Student s: list) dtos.add(mapper.toDto(s));
        return dtos;
    }

    @Override
    public StudentDto update(Long id, StudentDto dto) {
        Student existing = repo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Student not found"));
        existing.setName(dto.getName());
        existing.setMajor(dto.getMajor());
        return mapper.toDto(repo.save(existing));
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }
}
