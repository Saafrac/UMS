package com.example.demo.service;


import com.example.demo.dto.auth.JwtResponse;
import com.example.demo.dto.auth.LoginRequest;
import com.example.demo.dto.auth.RegisterRequest;

public interface AuthService {
    JwtResponse register(RegisterRequest req);
    JwtResponse login(LoginRequest req);
}