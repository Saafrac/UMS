package com.example.demo.dto.enrollment;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EnrollmentDto {
    private Long id;
    private Long studentId;
    private Long courseId;
}
