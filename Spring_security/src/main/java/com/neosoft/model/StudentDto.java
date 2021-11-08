package com.neosoft.model;

import java.util.Set;

import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
@Data
@Setter
@Getter


public class StudentDto {


	
	private String firstname;
  	private String lastname;
	 private String username;
	    private String password;
	    private String email;
	    private String phone;
	    private String name;
	   @OneToMany
	    private Set<Project> project;



	    public Student getStudentFromDto(){
	        Student student	 = new Student();
	        student.setFirstname(firstname);
	        student.setLastname(lastname);
	        student.setUsername(username);
	        student.setPassword(password);
	        student.setEmail(email);
	        student.setPhone(phone);
	        student.setName(name);
	        student.setProject(project);
	        
	        return student;
	    }
	    
	}

