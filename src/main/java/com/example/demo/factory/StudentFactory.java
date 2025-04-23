package com.example.demo.factory;


import com.example.demo.dto.student.StudentDto;
import com.example.demo.entity.Student;
import com.example.demo.entity.User;
import org.springframework.stereotype.Component;

@Component
public class StudentFactory {
    public Student fromDto(StudentDto dto, User user) {
        return Student.builder()
                .id(dto.getId())
                .name(dto.getName())
                .major(dto.getMajor())
                .user(user)
                .build();
    }
}
