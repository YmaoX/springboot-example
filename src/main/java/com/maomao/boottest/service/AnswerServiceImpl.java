package com.maomao.boottest.service;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maomao.boottest.dto.AnswerDTO;
import com.maomao.boottest.dto.UserDTO;
import com.maomao.boottest.entity.Answer;
import com.maomao.boottest.entity.Question;
import com.maomao.boottest.entity.User;
import com.maomao.boottest.error.BasicException;
import com.maomao.boottest.repository.AnswerRepo;
import com.maomao.boottest.repository.QuestionRepo;
import com.maomao.boottest.repository.UserRepo;
import com.maomao.boottest.utils.ErrorCodes;

@Service
public class AnswerServiceImpl implements AnswerService {

	@Autowired
	private UserService userService;

	@Autowired
	private AnswerRepo answerRepo;

	@Autowired
	private QuestionRepo questionRepo;

	@Autowired
	private UserRepo userRepo;

	@Override
	public AnswerDTO createAnswer(final String questionTitle, final String content, final String userId) {
		final Question question = checkQuestionExist(questionTitle);

		final User user = userRepo.findUserByIdentifier(userId);
		if (user == null) {
			throw new BasicException(ErrorCodes.USER_NOT_FOUND, ErrorCodes.USER_NOT_FOUND_MSG, userId);
		}

		final Answer answer = new Answer();
		answer.setContent(content);
		answer.setQuestion(question);
		answer.setUser(user);
		answer.setCreationTimestamp(new Date());

		final Answer saved = answerRepo.save(answer);
		return toDTO(saved);
	}

	@Override
	@Transactional
	public AnswerDTO createAnswerWithUser(final String questionTitle, final String content, final UserDTO user) {
		final Question question = checkQuestionExist(questionTitle);
		//create user
		final User savedUser = userService.createRepoUser(user.getIdentifier(), user.getName(), user.getBirthDay());

		final Answer answer = new Answer();
		answer.setContent(content);
		answer.setQuestion(question);
		answer.setUser(savedUser);
		answer.setCreationTimestamp(new Date());

		final Answer saved = answerRepo.save(answer);
		return toDTO(saved);
	}

	private Question checkQuestionExist(final String questionTitle) {
		final Question question = questionRepo.findQuestionByTitle(questionTitle);
		if (question == null) {
			throw new BasicException(ErrorCodes.QUESTION_NOT_FOUND, ErrorCodes.QUESTION_NOT_FOUND_MSG, questionTitle);
		}
		return question;
	}

	@Override
	public List<AnswerDTO> getAnswersByQuestion(final String questionTitle) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AnswerDTO> getAnswersByUser(final String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	//anwser doesn't contain question
	@Override
	public AnswerDTO toDTO(final Answer answer) {
		final AnswerDTO dto = new AnswerDTO();
		dto.setContent(answer.getContent());
		dto.setUser(userService.toDTO(answer.getUser()));
		return dto;
	}

}
