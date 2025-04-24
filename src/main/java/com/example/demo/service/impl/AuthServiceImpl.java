package com.example.demo.service.impl;


import com.example.demo.dto.auth.JwtResponse;
import com.example.demo.dto.auth.LoginRequest;
import com.example.demo.dto.auth.RegisterRequest;
import com.example.demo.entity.User;
import com.example.demo.mapper.AuthMapper;
import com.example.demo.repository.UserRepository;
import com.example.demo.security.JwtUtils;
import com.example.demo.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepo;
    private final AuthMapper mapper;
    private final PasswordEncoder encoder;
    private final AuthenticationManager authManager;
    private final JwtUtils jwtUtils;

    @Override
    @Transactional
    public JwtResponse register(RegisterRequest req) {
        if (userRepo.findByUsername(req.getUsername()).isPresent())
            throw new RuntimeException("Username taken");
        if (userRepo.findByEmail(req.getEmail()).isPresent())
            throw new RuntimeException("Email in use");
        User user = mapper.toUser(req);
        user.setPassword(encoder.encode(req.getPassword()));
        user = userRepo.save(user);
        String token = jwtUtils.generateToken(user.getUsername());
        return JwtResponse.builder()
                .token(token).userId(user.getId())
                .username(user.getUsername())
                .email(user.getEmail())
                .role(user.getRole().name())
                .build();
    }

    @Override
    @Transactional
    public JwtResponse login(LoginRequest req) {
        Authentication authentication = authManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        req.getUsernameOrEmail(),
                        req.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String username = ((UserDetails) authentication.getPrincipal()).getUsername();
        com.example.demo.entity.User userEntity = userRepo.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));

        String token = jwtUtils.generateToken(username);
        return JwtResponse.builder()
                .token(token)
                .userId(userEntity.getId())
                .username(userEntity.getUsername())
                .email(userEntity.getEmail())
                .role(userEntity.getRole().name())
                .build();
    }
}

