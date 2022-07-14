package com.prateek.StudentEventManagementSystem.service;

import java.util.List;

import com.prateek.StudentEventManagementSystem.entity.Student;

public interface IStudentService {

	List<Student> getAllStudents();

	Student saveStudent(Student theStudent);

	Student getStudent(long theId);

   Student updateStudent(Student student);

	void deleteStudent(long theId);
}
