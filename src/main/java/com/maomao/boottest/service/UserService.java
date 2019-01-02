package com.maomao.boottest.service;

import java.time.LocalDate;

import com.maomao.boottest.dto.UserDTO;
import com.maomao.boottest.entity.User;

public interface UserService {

	User createRepoUser(String id, String name, LocalDate birthday);

	UserDTO createUser(String id, String name, LocalDate birthday);

	UserDTO getUserById(String name);

	UserDTO toDTO(User user);
}
