package com.prateek.StudentEventManagementSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.anshuman.StudentEventManagementSystem.entity.Student;
import com.anshuman.StudentEventManagementSystem.service.StudentService;

@Controller
@RequestMapping("/")
public class StudentController {
	

	private StudentService studentService;

   @Autowired
   public StudentController(StudentService studentService) {
      super();
      this.studentService = studentService;
   }
	
	@GetMapping()
	@Transactional
	public String loadHomePage(Model theModel) {
		return "redirect:/students";
	}


   @PreAuthorize("hasAnyRole('ADMIN','USER')")
	@GetMapping("/students")
	@Transactional
	public String listStudents(Model model) {
      model.addAttribute("students", studentService.getAllStudents());
      return "students";
	}

   @PreAuthorize("hasAnyRole('ADMIN','USER')")
   @GetMapping("/students/new")
   public String createStudentForm(Model model) {

      // create student object to hold student form data
      Student student = new Student();
      model.addAttribute("student", student);
      return "create_student";

   }

   @PreAuthorize("hasAnyRole('ADMIN','USER')")
   @PostMapping("/students")
   public String saveStudent(@ModelAttribute("student") Student student) {
      studentService.saveStudent(student);
      return "redirect:/students";
   }

   @PreAuthorize("hasRole('ADMIN')")
   @GetMapping("/students/edit/{id}")
   public String editStudentForm(@PathVariable Long id, Model model) {
      model.addAttribute("student", studentService.getStudent(id));
      return "edit_student";
   }

   @PreAuthorize("hasRole('ADMIN')")
   @PostMapping("/students/update/{id}")
   public String updateStudent(@PathVariable Long id,
         @ModelAttribute("student") Student student,
         Model model) {

      // get student from database by id
      Student existingStudent = studentService.getStudent(id);
      existingStudent.setId(id);
      existingStudent.setFirstName(student.getFirstName());
      existingStudent.setLastName(student.getLastName());
      existingStudent.setCourse(student.getCourse());
      existingStudent.setCountry(student.getCountry());

      // save updated student object
      studentService.updateStudent(existingStudent);
      return "redirect:/students";
   }

   @PreAuthorize("hasRole('ADMIN')")
   @GetMapping("/students/delete/{id}")
   public String deleteStudent(@PathVariable Long id) {
      studentService.deleteStudent(id);
      return "redirect:/students";
   }

}
