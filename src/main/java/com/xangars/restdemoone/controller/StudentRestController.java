package com.xangars.restdemoone.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.xangars.restdemoone.entity.Student;
import com.xangars.restdemoone.exception.StudentNotFoundException;
import com.xangars.restdemoone.service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentRestController {

	@Autowired
	public StudentService studentService;
	
	@GetMapping("/list")
	public List<Student> findAll() {
		return studentService.findAll();
	}
	
	@GetMapping("/list/{id}")
	public Student findStudentById(@PathVariable int id) {
		
		Student student = studentService.findById(id);
		
		if (student == null)
			throw new StudentNotFoundException("Requested resource was not found");
		
		return student;
	
	}
	
	@PostMapping("/list")
	public ResponseEntity<Student> saveStudent(@RequestBody Student student) {
		
		Student savedStudent = studentService.save(student);
		
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(savedStudent.getId())
				.toUri();
		
		return ResponseEntity.created(location).build();
		
	}
	
	@PutMapping("/list")
	public ResponseEntity<Student> updateStudent(@RequestBody Student student) {
		
		Student existingUser = studentService.findById(student.getId());
		
		Student savedStudent = studentService.save(student);
		
		if(existingUser == null) {
		
			URI location = ServletUriComponentsBuilder
					.fromCurrentRequest()
					.path("/{id}")
					.buildAndExpand(savedStudent.getId())
					.toUri();
			
			return ResponseEntity.created(location).build();
			
		}
		
		return new ResponseEntity<>(HttpStatus.OK);
					
	}
	
	@DeleteMapping("/list/{id}")
	public void deleteStudent(@PathVariable int id) {
		
		Student studentToBeDeleted = studentService.findById(id);
		
		if(studentToBeDeleted == null)
			throw new StudentNotFoundException("Requested resource was not found");
		
		studentService.delete(studentToBeDeleted);
		
	}
	
}
