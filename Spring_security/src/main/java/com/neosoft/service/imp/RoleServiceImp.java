package com.neosoft.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neosoft.model.Role;
import com.neosoft.repositiry.RoleRepo;
import com.neosoft.service.RoleService;

@Service
public class RoleServiceImp implements RoleService {

	@Autowired
	private RoleRepo roleRepo;
	
	@Override
    public Role findByName(String name) {
        Role role = roleRepo.findRoleByName(name);
        return role;
    }
}
