package com.sprint1.ebs.user.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sprint1.ebs.user.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{

	User findByEmail(String email);
}
