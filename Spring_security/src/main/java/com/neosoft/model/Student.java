package com.neosoft.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;



@Setter
@Getter
@ToString
@Entity
@NoArgsConstructor
@AllArgsConstructor
@SuppressWarnings("unused")
public class Student {
	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

	@NotNull
	private String firstname;
    @NotNull
	private String lastname;
    
    @Column
    private String username;
    @Column
    @JsonIgnore
    private String password;

    @Column
    private String email;

    @Column
    private String phone;

    @Column
    private String name;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
   
    private Set<Role> roles;

    @OneToMany
    private Set<Project> project;
}
