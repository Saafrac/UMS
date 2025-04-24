package com.example.demo.dto.student;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentDto {
    private Long id;

    @NotBlank(message = "Name must not be blank")
    @Size(max = 100, min = 3, message = "3 <= Name <= 100 characters")
    private String name;


    @NotBlank(message = "Major must not be blank")
    @Size(max = 100, message = "Major ≤ 100 characters")
    private String major;

    private Long userId;
}