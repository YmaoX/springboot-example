package com.maomao.boottest.service;

import com.maomao.boottest.dto.QuestionDTO;
import com.maomao.boottest.entity.Question;

public interface QuestionService {

	QuestionDTO createQuestion(String title, String content);

	QuestionDTO getQuestionByTitle(String title);

	QuestionDTO toDTO(Question question);
}
