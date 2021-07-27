package com.amit.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.amit.dto.Student;
import com.amit.service.StudentService;

@CrossOrigin
@RestController
//@RequestMapping("/api")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@GetMapping("/students")
	public List<Student> getStudents() {
		return this.studentService.getAllStudents();
	}
	
	@PostMapping("/student")
	public ResponseEntity<String> addStudent(@RequestBody Student student) {
		studentService.addStudent(student);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

}
