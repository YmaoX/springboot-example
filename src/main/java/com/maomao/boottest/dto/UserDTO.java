package com.maomao.boottest.dto;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDTO {

	private String identifier;

	private String name;

	private LocalDate birthDay;

	private List<AnswerDTO> answers;

	public String getIdentifier() {
		return identifier;
	}

	public void setIdentifier(final String identifier) {
		this.identifier = identifier;
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public LocalDate getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(final LocalDate birthDay) {
		this.birthDay = birthDay;
	}

	public List<AnswerDTO> getAnswers() {
		return answers;
	}

	public void setAnswers(final List<AnswerDTO> answers) {
		this.answers = answers;
	}
}
