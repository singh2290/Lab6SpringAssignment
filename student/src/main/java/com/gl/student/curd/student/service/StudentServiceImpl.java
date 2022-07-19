package com.gl.student.curd.student.service;

import java.util.List;

import com.gl.student.curd.student.model.Student;

public interface StudentServiceImpl {
	public List<Student> findAll();
	public Student findById(int Id);
	public void save(Student student);
	public void deleteById(int id);

}
