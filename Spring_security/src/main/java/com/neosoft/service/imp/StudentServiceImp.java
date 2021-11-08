package com.neosoft.service.imp;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.neosoft.model.Role;
import com.neosoft.model.Student;
import com.neosoft.model.StudentDto;
import com.neosoft.repositiry.StudentRepo;
import com.neosoft.service.RoleService;
import com.neosoft.service.StudetService;


@Service(value = "StudetService")
public class StudentServiceImp implements StudetService, UserDetailsService {

    @Autowired
    private RoleService roleService;

    @Autowired
    private StudentRepo studentRepo;

    @Autowired
    private BCryptPasswordEncoder bcryptEncoder;

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Student student = studentRepo.findByUsername(username);
        if(student == null){
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User(student.getUsername(), student.getPassword(), getAuthority(student));
    }

    private Set<SimpleGrantedAuthority> getAuthority(Student student) {
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        student.getRoles().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getName()));
        });
        return authorities;
    }

    public List<Student> findAll() {
        List<Student> list = new ArrayList<>();
        studentRepo.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    @Override
    public Student findOne(String username) {
        return studentRepo.findByUsername(username);
    }

    @Override
    public Student save(StudentDto user) {

        Student student = user.getStudentFromDto();
        student.setPassword(bcryptEncoder.encode(user.getPassword()));

        Role role = roleService.findByName("USER");
        Set<Role> roleSet = new HashSet<>();
        roleSet.add(role);

        if(student.getEmail().split("@")[1].equals("admin.edu")){
            role = roleService.findByName("ADMIN");
            roleSet.add(role);
        }

        student.setRoles(roleSet);
        return studentRepo.save(student);
    }
}
