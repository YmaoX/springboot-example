package com.maomao.boottest.service;

import static java.util.stream.Collectors.toList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maomao.boottest.dto.AnswerDTO;
import com.maomao.boottest.dto.QuestionDTO;
import com.maomao.boottest.entity.Answer;
import com.maomao.boottest.entity.Question;
import com.maomao.boottest.repository.QuestionRepo;

@Service
public class QuestionServiceImpl implements QuestionService {

	@Autowired
	private QuestionRepo questionRepo;

	@Autowired
	private AnswerService answerService;

	@Override
	public QuestionDTO createQuestion(final String title, final String content) {
		final Question question = new Question();
		question.setTitle(title);
		question.setContent(content);
		final Question saved = questionRepo.save(question);
		return toDTO(saved);
	}

	@Override
	public QuestionDTO getQuestionByTitle(final String title) {
		final Question found = questionRepo.findQuestionByTitle(title);
		final QuestionDTO rtn = toDTO(found);
		//one to many, lazy fetch answers
		fillAnswers(rtn, found.getAnswers());
		return rtn;
	}

	//question contains all answer
	@Override
	public QuestionDTO toDTO(final Question question) {
		if (question == null) {
			return null;
		}
		final QuestionDTO dto = new QuestionDTO();
		dto.setTitle(question.getTitle());
		dto.setContent(question.getContent());
		return dto;
	}

	private void fillAnswers(final QuestionDTO dto, final List<Answer> answers) {
		if (answers != null) {
			final List<AnswerDTO> answerDTOs = answers.stream().map(answerService::toDTO).collect(toList());
			dto.setAnswers(answerDTOs);
		}
	}

}
