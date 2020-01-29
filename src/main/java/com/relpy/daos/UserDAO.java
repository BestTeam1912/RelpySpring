package com.relpy.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.relpy.models.User;

public interface UserDAO extends JpaRepository<User, Long>{

}
