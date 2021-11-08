package com.neosoft.repositiry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.neosoft.model.Project;
@Repository
public interface ProjectRepo extends JpaRepository<Project, Integer> {

}
