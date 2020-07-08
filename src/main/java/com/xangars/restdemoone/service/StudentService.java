package com.xangars.restdemoone.service;

import java.util.List;

import com.xangars.restdemoone.entity.Student;

public interface StudentService {

	public List<Student> findAll();
	
	public Student findById(int id);
	
	public Student save(Student student);
	
	public void delete(Student student);
	
}
