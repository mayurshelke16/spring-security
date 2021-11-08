package com.neosoft.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@Setter
@Getter
@ToString
@Entity
@NoArgsConstructor
@AllArgsConstructor
@SuppressWarnings("unused")
public class Project {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int pid;
	
	@NotNull
	private String project_name;
	@NotNull
	private String duration;
		
 
}
