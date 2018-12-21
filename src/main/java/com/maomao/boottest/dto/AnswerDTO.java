package com.maomao.boottest.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class AnswerDTO {

	private String content;

	private QuestionDTO question;

	private UserDTO user;

	public String getContent() {
		return content;
	}

	public void setContent(final String content) {
		this.content = content;
	}

	public QuestionDTO getQuestion() {
		return question;
	}

	public void setQuestion(final QuestionDTO question) {
		this.question = question;
	}

	public UserDTO getUser() {
		return user;
	}

	public void setUser(final UserDTO user) {
		this.user = user;
	}

}
