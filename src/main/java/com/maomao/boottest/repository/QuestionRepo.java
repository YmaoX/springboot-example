package com.maomao.boottest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maomao.boottest.entity.Question;

public interface QuestionRepo extends JpaRepository<Question, Long> {

	Question findQuestionByTitle(String title);
}
