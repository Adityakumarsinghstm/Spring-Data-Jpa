package com.dailycodebuffer.spring.data.jpa.repository;

import com.dailycodebuffer.spring.data.jpa.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
}
