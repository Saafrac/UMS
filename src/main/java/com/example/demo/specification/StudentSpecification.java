package com.example.demo.specification;


import com.example.demo.entity.Student;
import org.springframework.data.jpa.domain.Specification;
import jakarta.persistence.criteria.*;

public class StudentSpecification {

    public static Specification<Student> nameContains(String name) {
        return (root, query, cb) ->
                cb.like(cb.lower(root.get("name")), "%" + name.toLowerCase() + "%");
    }

    public static Specification<Student> majorEquals(String major) {
        return (root, query, cb) ->
                cb.equal(cb.lower(root.get("major")), major.toLowerCase());
    }
}
