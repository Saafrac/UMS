package com.example.demo.controller;

import com.example.demo.dto.student.StudentDto;
import com.example.demo.service.StudentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;

@SecurityScheme(
        name = "bearerAuth",
        type = SecuritySchemeType.HTTP,
        scheme = "bearer",
        bearerFormat = "JWT"
)

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
@Tag(name = "Students", description = "CRUD operations on students")
public class StudentController {
    private final StudentService svc;

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<StudentDto> create(
            @Valid
            @RequestBody StudentDto dto) {
        return ResponseEntity.ok(svc.create(dto));
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ADMIN','TEACHER','STUDENT')")
    public ResponseEntity<StudentDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(svc.getById(id));
    }


    @Operation(
            summary = "Get all students",
            description = "Returns a paginated list of students, filtered by name and major. Only ADMIN and TEACHER roles can access this.",
            security = @SecurityRequirement(name = "bearerAuth"),
            responses = {
                    @ApiResponse(responseCode = "200", description = "List of students returned successfully"),
                    @ApiResponse(responseCode = "403", description = "Forbidden - insufficient permissions"),
                    @ApiResponse(responseCode = "401", description = "Unauthorized - missing or invalid token")
            }
    )
    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN','TEACHER')")
    public ResponseEntity<Page<StudentDto>> getAll(
            @Parameter(description = "Filter by student name (optional)", example = "John")
            @RequestParam(required = false) String name,

            @Parameter(description = "Filter by student major (optional)", example = "Computer Science")
            @RequestParam(required = false) String major,

            @Parameter(hidden = true)
            Pageable pageable
    ) {
        Page<StudentDto> page = svc.getAll(name, major, pageable);
        return ResponseEntity.ok(page);
    }


    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<StudentDto> update(
            @PathVariable Long id,
            @Valid
            @RequestBody StudentDto dto) {
        return ResponseEntity.ok(svc.update(id, dto));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        svc.delete(id);
        return ResponseEntity.noContent().build();
    }
}
