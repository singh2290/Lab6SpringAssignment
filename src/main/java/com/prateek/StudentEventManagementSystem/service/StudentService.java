package com.prateek.StudentEventManagementSystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anshuman.StudentEventManagementSystem.entity.Student;
import com.anshuman.StudentEventManagementSystem.repository.StudentRepository;

@Service
public class StudentService implements IStudentService{
	
	

	private StudentRepository studentRepository;

   @Autowired
   public StudentService(StudentRepository studentRepository) {
      super();
      this.studentRepository = studentRepository;
   }

	@Override
	public Student getStudent(long theId) {
      return studentRepository.findById(theId).get();
	}

   @Override
   public Student updateStudent(Student student) {
      return studentRepository.save(student);
   }

   @Override
	public void deleteStudent(long theId) {
	   Student std = getStudent(theId);
	   if (std != null) {
         studentRepository.delete(std);
      } else {
	      //TODO throw exception student not found
      }
	}



	@Override
	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}



	@Override
	public Student saveStudent(Student theStudent) {
		return studentRepository.save(theStudent);
	}
}
