package com.maomao.boottest.utils;

public final class ErrorCodes {

	private ErrorCodes() {

	}

	//error message keys
	public static final String QUESTION_NOT_FOUND_MSG = "question.not_found_by_title";
	public static final String USER_NOT_FOUND_MSG = "user.not_found_by_id";

	private static final int QUESTION_ERROR_BASE = 10000;
	public static final int QUESTION_NOT_FOUND = QUESTION_ERROR_BASE + 1;

	private static final int USER_ERROR_BASE = 20000;
	public static final int USER_NOT_FOUND = USER_ERROR_BASE + 1;
}
