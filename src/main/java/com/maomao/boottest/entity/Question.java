package com.maomao.boottest.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "questions", schema = "basic")
public class Question implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "QUE_SEQ", allocationSize = 25)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "QUE_SEQ")
	@Column(unique = true, nullable = false)
	private long questionId;

	@Column(unique = true, nullable = false)
	private String title;

	@Column(nullable = false)
	//test alternative
	@CreationTimestamp
	private Date creationTimestamp;

	private String content;

	@OneToMany(mappedBy = "question")
	private List<Answer> answers;

	public long getQuestionId() {
		return questionId;
	}

	public void setQuestionId(final long questionId) {
		this.questionId = questionId;
	}

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

	public Date getCreationTimestamp() {
		return creationTimestamp;
	}

	public void setCreationTimestamp(final Date creationTimestamp) {
		this.creationTimestamp = creationTimestamp;
	}

	public List<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(final List<Answer> answers) {
		this.answers = answers;
	}

}
