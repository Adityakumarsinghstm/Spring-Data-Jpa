package com.dailycodebuffer.spring.data.jpa.repository;

import com.dailycodebuffer.spring.data.jpa.entities.Guardian;
import com.dailycodebuffer.spring.data.jpa.entities.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentRepositoryTest {
    @Autowired
   private StudentRepository studentRepository ;

    @Test
    public void saveStudent()
    {
        Student student1 = Student.builder().firstName("aditya").lastName("singh")
               .emailId("aditya@gmail.com")
               //.guardianName("saroj")
                //.guardianEmail("saroj@gmail.com")
               //.guardianPhone("87236482")
                .build();

        studentRepository.save(student1);
    }
    @Test
    public void saveStudentWithGuardian()
    {
        Guardian guardian = Guardian.builder()
                .email("rambabusingh123@gmail.com")
                .name("rambabusingh")
                .phone("9877384647")
                .build();

        Student student = Student.builder()
                .firstName("Deepak")
                .lastName("singh")
                .emailId("deepak123@gmail.com")
                .guardian(guardian)
                .build();
        studentRepository.save(student);

    }

    @Test
    public void printAllStudent()
    {
        List<Student> studentList = studentRepository.findAll();
        System.out.println("Student List is :"+studentList);
    }
    @Test
    public void printAllStudentByfirstName()
    {
        List<Student> student = studentRepository.findByFirstName("aditya");
        System.out.println("student "+ student);
    }

    @Test
    public void printAllStudentByfirstNameContaining()
    {
        List<Student> student = studentRepository.findByFirstNameContaining("de");
        System.out.println("student "+ student);
    }

    @Test
    public void printAllStudentByGuardianName()
    {
        List<Student> student = studentRepository.findByGuardianName("saroj");
        System.out.println("student "+ student);
    }

    @Test
    public void printStudentByEmailId() {
        Student student = studentRepository.getStudentByEmail("aditya@gmail.com");
        System.out.println("Student "+ student);
    }

    @Test
    public void printStudentFirstNameByEmail() {
        String firstName = studentRepository.getStudentFirstNameByEmail("deepak123@gmail.com");
        System.out.println("First name :"+firstName);
    }

    @Test
    public void printGetStudentByEmailIdNative() {
        Student student = studentRepository.getStudentByEmailIdNative("deepak123@gmail.com");
        System.out.println("Student :"+student);
    }

    @Test
    public void printGetStudentByEmailIdNativeNameParam() {
        Student student = studentRepository.getStudentByEmailIdNative("deepak123@gmail.com");
        System.out.println("Student :"+student);
    }

    @Test
    public void updateFirstNameByEmailIdNative()
    {
        studentRepository.updateFirstNameByEmailId(
                "Deepak Singh",
                "deepak123@gmail.com"
        );
    }


}