package com.abhinav.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.abhinav.entity.StudentEntity;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, Long>{
	
	@Query(value = "select * from student s where s.studentname=:studentName", nativeQuery = true)
	public List<StudentEntity> findByStudentName(@Param("studentName") String studentName);
	
}
