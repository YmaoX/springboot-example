package com.maomao.boottest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maomao.boottest.entity.User;

public interface UserRepo extends JpaRepository<User, Long> {

	User findUserByIdentifier(String id);
}
