package com.example.demo.strategy;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.*;

@Component
@RequiredArgsConstructor
public class CourseSorter {
    private final Map<String, CourseSortStrategy> strategies;
    public CourseSortStrategy getStrategy(String key) {
        return strategies.getOrDefault(key, strategies.get("date"));
    }
}

