package com.student.mypack.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.student.mypack.model.Student;

public interface StudentRepository extends JpaRepository<Student,Integer> 
{

	
}
