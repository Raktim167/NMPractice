package com.springboot.first.app;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
	
	
	// http://localhost:8080/student
	@GetMapping("/student")
	public Student getStudent() {
		return new Student("Raktim","Deka");
	}

	@GetMapping("/students")
	public List<Student> getStudents() {
		List<Student> students = new ArrayList<>();
		students.add(new Student("Raktim", "Deka"));
		students.add(new Student("Manuel", "Neuer"));
		students.add(new Student("Thomas", "Muller"));
		students.add(new Student("Robert", "Lewan"));
		students.add(new Student("Joshua", "Kimmich"));
		return students;
	}
	
	// https://localhost:8081/student/1
	// @ParhVariable annotation
	@GetMapping("/student/{firstName}/{lastName}")
	public Student studentPathVariable(@PathVariable("firstName")String firstName,
			@PathVariable("lastName") String lastName) {
		return new Student(firstName, lastName);
	}
	
	// build rest API  to handle query parameter
	// http:localhost:8080/student/query?firstName=Raktim&lastName=Deka
	@GetMapping("/student/query")
	public Student studentQueryParam(
			@RequestParam(name = "firstName") String firstName,
			@RequestParam(name ="lastName") String lastName) {
		return new Student(firstName, lastName);
	}
	
	
}
