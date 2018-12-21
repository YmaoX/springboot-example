package com.maomao.boottest.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.maomao.boottest.dto.AnswerDTO;
import com.maomao.boottest.dto.UserDTO;
import com.maomao.boottest.service.AnswerService;
import com.maomao.boottest.service.UserService;

@RestController
@RequestMapping(value = "/user", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private AnswerService answerService;

	@RequestMapping(value = "", method = RequestMethod.POST)
	public UserDTO createUser(@RequestParam(required = true) final String identifier, @RequestParam final String name,
			@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) final LocalDate date) {
		return userService.createUser(identifier, name, date);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public UserDTO getUserById(@PathVariable final String id) {
		return userService.getUserById(id);
	}

	@RequestMapping(value = "/{id}/answer", method = RequestMethod.POST)
	public AnswerDTO postAnswer(@PathVariable final String id, @RequestParam final String questionTitle,
			@RequestParam final String content) {
		return answerService.createAnswer(questionTitle, content, id);
	}
}
