package com.xangars.restdemoone.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xangars.restdemoone.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{}
