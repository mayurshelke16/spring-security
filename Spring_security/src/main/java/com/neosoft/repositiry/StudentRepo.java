package com.neosoft.repositiry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.neosoft.model.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student, Long> {

	Student findByUsername(String username);

}
