package com.neosoft.service;

import java.util.List;

import com.neosoft.model.Student;
import com.neosoft.model.StudentDto;


public interface StudetService {

	Student save(StudentDto user);
	 List<Student> findAll();
	Student findOne(String username);

}
