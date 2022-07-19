package com.gl.student.curd.student.cotroller;

import java.security.Principal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.core.AuthenticatedPrincipal;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.context.SecurityContext;
//import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;

//import org.springframework.web.bind.annotation.RestController;

import com.gl.student.curd.student.model.Student;
import com.gl.student.curd.student.service.StudentService;

@Controller
//@RequestMapping("/students")
public class StudentController {
	@Autowired
	private StudentService studentService;

	@RequestMapping("/list")
	public String list(Model themodel) {
		List<Student> students = studentService.findAll();
		themodel.addAttribute("Students", students);
		return "list-student";
	}

	@RequestMapping("/Addform")
	public String showFormForAdd(Model themodel) {

		// create model attribute to bind form data
		Student student = new Student();

		themodel.addAttribute("Student", student);

		return "formaddorupdate";
	}

	@RequestMapping("/Updateform")
	public String showFormForUpdate(@RequestParam("studentId") int theId, Model theModel) {

		// get the Book from the service
		Student theStudent = studentService.findById(theId);

		// set Book as a model attribute to pre-populate the form
		theModel.addAttribute("Student", theStudent);

		// send over to our form
		return "formaddorupdate";
	}

	@PostMapping("/save")
	public String save(@RequestParam("id") int id, @RequestParam("firstName") String firstName,
			@RequestParam("lastName") String lastName, @RequestParam("course") String course,
			@RequestParam("country") String country, Student student) {
		System.out.println(id);
		if (id != 0) {
			student = studentService.findById(id);
			student.setFirstName(firstName);
			student.setLastName(lastName);
			student.setCourse(course);
			student.setCountry(country);
		} else
			student = new Student(firstName, lastName, course, country);

		studentService.save(student);
		return "redirect:/list";
	}

	@RequestMapping("/delete")
	public String delete(@RequestParam("studentId") int theId) {

		// delete the Book
		studentService.deleteById(theId);

		// redirect to /Books/list
		return "redirect:/list";

	}

	@RequestMapping("/403")
	public ModelAndView accesssDenied(Principal user) {

		ModelAndView model = new ModelAndView();

		if (user != null) {
			model.addObject("msg", "Hi " + user.getName() + ", you do not have permission to access this page!");
		} else {
			model.addObject("msg", "You do not have permission to access this page!");
		}

		model.setViewName("403");
		return model;
	}

}
