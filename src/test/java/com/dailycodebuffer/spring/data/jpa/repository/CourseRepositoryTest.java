package com.dailycodebuffer.spring.data.jpa.repository;

import com.dailycodebuffer.spring.data.jpa.entities.Course;
import com.dailycodebuffer.spring.data.jpa.entities.CourseMaterial;
import com.dailycodebuffer.spring.data.jpa.entities.Student;
import com.dailycodebuffer.spring.data.jpa.entities.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseRepositoryTest {

    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private CourseMaterialRepository courseMaterialRepository;
    @Test
    public void printAllCourses() {
        List<Course> courses = courseRepository.findAll();
        System.out.println("Courses : "+ courses);
    }
@Test
    public void saveCourseWithTeacher() {
    Teacher teacher = Teacher.builder()
            .firstName("Sanket")
            .lastName("Singhaniya")
            .build();

        Course course = Course.builder()
                .title("Python")
                .credit(5)
                .teacher(teacher)
              //  .courseMaterial(courseMaterial)
                .build();
    CourseMaterial courseMaterial = CourseMaterial.builder()
            .url("www.telusko.com")
            .course(course)
            .build();
    courseMaterialRepository.save(courseMaterial);
    courseRepository.save(course);
    }

    @Test
    public void findAllPaginataion() {
        Pageable firstPageWithThreeRecord = PageRequest.of(0, 3);
        Pageable secodPageWithTwoRecord = PageRequest.of(1, 2);

        List<Course> courses = courseRepository.findAll(secodPageWithTwoRecord).getContent();

        long totalPage = courseRepository.findAll(secodPageWithTwoRecord).getTotalPages();
        long totalElement = courseRepository.findAll(secodPageWithTwoRecord).getTotalElements();


        System.out.println("Total pages : " + totalPage);
        System.out.println("Total Elements : "+totalElement);

        System.out.println("Courses "+ courses);


    }
    @Test
    public void saveCourseWithStudentAndTeacher() {
        Teacher teacher = Teacher.builder()
                .firstName("Shyam")
                .lastName("kunwar")
                .build();
        Student student = Student.builder()
                .firstName("kaushal")
                .lastName("Raj")
                .emailId("kaushal@gmail.com")
                .build();
        Course course = Course.builder()
                .title("AI")
                .credit(7)
                .teacher(teacher)
                .build();
        course.addStudent(student);

        courseRepository.save(course);
    }
}