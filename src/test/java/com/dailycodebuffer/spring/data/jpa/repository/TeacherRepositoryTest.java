package com.dailycodebuffer.spring.data.jpa.repository;

import com.dailycodebuffer.spring.data.jpa.entities.Course;
import com.dailycodebuffer.spring.data.jpa.entities.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherRepositoryTest {
    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    public void saveTeacher() {
        Course courseDBA = Course.builder()
                .title("DBA")
                .credit(6)
                .build();

        Course courseJAVA = Course.builder()
                .title("Java")
                .credit(5)
                .build();
        Teacher teacher = Teacher.builder()
                .firstName("sohan")
                .lastName("verma")
                //.courses(List.of(courseDBA,courseJAVA))
                .build();

        teacherRepository.save(teacher);

    }

}