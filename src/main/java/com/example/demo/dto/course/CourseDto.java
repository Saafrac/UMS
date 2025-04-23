package com.example.demo.dto.course;

import lombok.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CourseDto {
    private Long id;
    private String title;
    private String description;
    private LocalDateTime startDate;
    private Long teacherId;
}
