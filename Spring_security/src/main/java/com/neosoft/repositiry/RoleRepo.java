package com.neosoft.repositiry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.neosoft.model.Role;

@Repository
public interface RoleRepo extends JpaRepository<Role, Integer>{

	Role findRoleByName(String name);

}
