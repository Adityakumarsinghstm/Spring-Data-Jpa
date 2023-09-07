package com.dailycodebuffer.spring.data.jpa.repository;

import com.dailycodebuffer.spring.data.jpa.entities.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher,Long> {

}
