package com.dailycodebuffer.spring.data.jpa.repository;

import com.dailycodebuffer.spring.data.jpa.entities.CourseMaterial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseMaterialRepository extends JpaRepository<CourseMaterial,Long> {

}
