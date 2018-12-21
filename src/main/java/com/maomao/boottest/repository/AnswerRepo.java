package com.maomao.boottest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maomao.boottest.entity.Answer;

public interface AnswerRepo extends JpaRepository<Answer, Long> {
//
}
