package com.maomao.boottest.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "answers", schema = "basic")
public class Answer implements Serializable {

	private static final long serialVersionUID = 1L;

	//https://stackoverflow.com/questions/10041938/how-to-choose-the-id-generation-strategy-when-using-jpa-and-hibernate
	@Id
	@SequenceGenerator(name = "ANS_SEQ", allocationSize = 25)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ANS_SEQ")
	@Column(unique = true, nullable = false)
	private long answerId;

	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date creationTimestamp;

	private String content;

	@ManyToOne
	@JoinColumn(name = "question_id", updatable = false)
	private Question question;

	@ManyToOne
	@JoinColumn(name = "user_id", updatable = false)
	private User user;

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

	public User getUser() {
		return user;
	}

	public void setUser(final User user) {
		this.user = user;
	}

}
