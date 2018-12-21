package com.maomao.boottest.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class QuestionDTO {

	private String title;

	private String content;

	private List<AnswerDTO> answers;

	public String getTitle() {
		return title;
	}

	public void setTitle(final String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(final String content) {
		this.content = content;
	}

	public List<AnswerDTO> getAnswers() {
		return answers;
	}

	public void setAnswers(final List<AnswerDTO> answers) {
		this.answers = answers;
	}

}
