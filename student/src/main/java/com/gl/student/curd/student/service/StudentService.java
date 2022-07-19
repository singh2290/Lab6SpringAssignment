// business logic goes -- 
//controller is light weight validation

package com.gl.student.curd.student.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gl.student.curd.student.model.Student;
import com.gl.student.curd.student.repository.StudentRepository;

@Service
public class StudentService implements StudentServiceImpl {
	
	@Autowired
	public StudentRepository studentRepository;

	
	@Override
	public List<Student> findAll() {
		List<Student> students =  studentRepository.findAll();
		// TODO Auto-generated method stub
		return students;
	}

	@Override
	public Student findById(int Id) {
		// no object to return send Empty object to avoid null pointer exception
		Optional<Student> student;
		student =studentRepository.findById(Id);
		// TODO Auto-generated method stub
		return student.get();
	}

	@Override
	public void save(Student student) {
		// TODO Auto-generated method stub
		studentRepository.save(student);
		
	}
	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		studentRepository.deleteById(id);
		
	}

}
