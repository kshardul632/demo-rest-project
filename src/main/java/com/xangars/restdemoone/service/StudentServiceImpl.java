package com.xangars.restdemoone.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xangars.restdemoone.entity.Student;
import com.xangars.restdemoone.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository;
	
	@Override
	public List<Student> findAll() {
		return studentRepository.findAll();
	}

	@Override
	public Student findById(int id) {
	
		Optional<Student> result = studentRepository.findById(id);
		
		Student student = null;
		
		if (result.isPresent())
			student = result.get();
		
		return student;
	
	}

	@Override
	public Student save(Student student) {
		return studentRepository.save(student);
	}

	@Override
	public void delete(Student student) {
		studentRepository.delete(student);
	}

}
