package com.example.demo.specification;

import com.example.demo.entity.Student;
import org.springframework.data.jpa.domain.Specification;

public class CourseSpecification {

    public static Specification<Student> titleContains(String title) {
        return (root, query, cb) ->
                cb.like(cb.lower(root.get("name")), "%" + title.toLowerCase() + "%");
    }

    public static Specification<Student> descriptionContains(String description) {
        return (root, query, cb) ->
                cb.like(cb.lower(root.get("name")), "%" + description.toLowerCase() + "%");
    }
}
