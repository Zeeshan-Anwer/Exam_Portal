package com.myexamportal.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myexamportal.app.model.Role;


public interface RoleRepository extends JpaRepository<Role, Long> {

}
