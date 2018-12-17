package com.maomao.boottest.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "answers")
public class Answer implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private long answerId;

	@Column(nullable = false)
	@Type(type = "timestamp")
	private Date creationTimestamp;

	private String content;

	@ManyToOne
	@JoinColumn(name = "question_id", updatable = false)
	private Question question;

	public long getAnswerId() {
		return answerId;
	}

	public void setAnswerId(final long answerId) {
		this.answerId = answerId;
	}

	public Date getCreationTimestamp() {
		return creationTimestamp;
	}

	public void setCreationTimestamp(final Date creationTimestamp) {
		this.creationTimestamp = creationTimestamp;
	}

	public String getContent() {
		return content;
	}

	public void setContent(final String content) {
		this.content = content;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(final Question question) {
		this.question = question;
	}

}
