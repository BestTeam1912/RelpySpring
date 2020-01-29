package com.relpy.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.relpy.models.User;

@Repository
public interface UserDAO extends JpaRepository<User, Long>{
	User getUserById(Long id);
}
