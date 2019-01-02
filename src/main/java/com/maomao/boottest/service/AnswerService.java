package com.maomao.boottest.service;

import java.util.List;

import com.maomao.boottest.dto.AnswerDTO;
import com.maomao.boottest.dto.UserDTO;
import com.maomao.boottest.entity.Answer;

public interface AnswerService {

	AnswerDTO createAnswer(String questionTitle, String content, String userId);

	AnswerDTO createAnswerWithUser(String questionTitle, String content, UserDTO user);

	List<AnswerDTO> getAnswersByQuestion(String questionTitle);

	List<AnswerDTO> getAnswersByUser(String userId);

	AnswerDTO toDTO(Answer answer);
}
