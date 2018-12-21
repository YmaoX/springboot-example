package com.maomao.boottest.service;

import java.time.LocalDate;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maomao.boottest.dto.UserDTO;
import com.maomao.boottest.entity.User;
import com.maomao.boottest.repository.UserRepo;

@Service
//@Profile("prod")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo userRepo;

	@Override
	public UserDTO createUser(final String id, final String name, final LocalDate birthday) {
		final User user = new User();
		user.setIdentifier(id);
		user.setName(name);
		user.setBirthday(birthday);
		user.setCreationTimestamp(new Date());
		final User saved = userRepo.save(user);
		return toDTO(saved);
	}

	@Override
	public UserDTO getUserById(final String id) {
		final User found = userRepo.findUserByIdentifier(id);
		return toDTO(found);
	}

	@Override
	public UserDTO toDTO(final User user) {
		if (user == null) {
			return null;
		}
		final UserDTO dto = new UserDTO();
		dto.setIdentifier(user.getIdentifier());
		dto.setBirthDay(user.getBirthday());
		dto.setName(user.getName());
		return dto;
	}

}
