package com.gl.student.curd.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gl.student.curd.student.model.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

	public String findByFirstName(String name);

}
