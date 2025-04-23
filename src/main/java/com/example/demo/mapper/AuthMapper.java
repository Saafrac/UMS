package com.example.demo.mapper;


import com.example.demo.dto.auth.RegisterRequest;
import com.example.demo.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring")
public interface AuthMapper {
    @Mapping(target="role", expression="java(User.Role.valueOf(req.getRole()))")
    User toUser(RegisterRequest req);
}
