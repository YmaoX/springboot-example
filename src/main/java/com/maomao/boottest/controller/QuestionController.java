package com.maomao.boottest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.maomao.boottest.dto.QuestionDTO;
import com.maomao.boottest.service.QuestionService;

@RestController
@RequestMapping(value = "/question", produces = MediaType.APPLICATION_JSON_VALUE)
public class QuestionController {

	@Autowired
	private QuestionService questionService;

	@RequestMapping(value = "", method = RequestMethod.POST)
	public QuestionDTO createQuestion(@RequestParam final String title, @RequestParam final String content) {
		return questionService.createQuestion(title, content);
	}

	@RequestMapping(value = "/{title}", method = RequestMethod.GET)
	public QuestionDTO getQuestion(@PathVariable final String title) {
		return questionService.getQuestionByTitle(title);
	}
}
