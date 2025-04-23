package com.example.demo.mapper;

import com.example.demo.dto.student.StudentDto;
import com.example.demo.entity.Student;
import com.example.demo.entity.User;
import org.mapstruct.*;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface StudentMapper {
    @Mapping(target = "user", expression = "java(mapUser(dto.getUserId()))")
    Student toEntity(StudentDto dto);

    @Mapping(target = "userId", source = "entity.user.id")
    StudentDto toDto(Student entity);

    default User mapUser(Long userId) {
        if (userId == null) return null;
        User u = new User();
        u.setId(userId);
        return u;
    }
}
