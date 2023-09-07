package com.dailycodebuffer.spring.data.jpa.repository;

import com.dailycodebuffer.spring.data.jpa.entities.Student;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
    public List<Student> findByFirstName(String name);
    public List<Student> findByFirstNameContaining(String name);
    public List<Student> findByGuardianName(String guardianName);

    //JPQL
    @Query("select s from Student s where s.emailId =?1")
    Student getStudentByEmail(String emailId);

    @Query("select s.firstName from Student s where s.emailId = ?1")
    String getStudentFirstNameByEmail(String emailId);


    //Native Query
    @Query(
            value = "SELECT * FROM tbl_student s where s.email_address =?1 ",
            nativeQuery = true
    )
    Student getStudentByEmailIdNative(String emailId);

    @Query(
            value = "SELECT * FROM tbl_student s where s.email_address :emailId",
            nativeQuery = true
    )
    Student getStudentByEmailIdNativeNameParam( @Param("emailId") String emailId);

    @Modifying
    @Transactional
    @Query(
            value = "UPDATE tbl_student SET first_name=?1 WHERE email_address=?2",
            nativeQuery = true
    )
    int updateFirstNameByEmailId(String firstName, String emailId);
}
