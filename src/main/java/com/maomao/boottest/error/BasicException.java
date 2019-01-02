package com.maomao.boottest.error;

public class BasicException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private final int code;
	private final String messageKey;
	private final Object[] params;

	public BasicException(final int code, final String messageKey, final Object... params) {
		this.code = code;
		this.messageKey = messageKey;
		this.params = params;
	}

	public int getCode() {
		return code;
	}

	public String getMessageKey() {
		return messageKey;
	}

	public Object[] getParams() {
		return params;
	}

	@Override
	public String toString() {
		return "code: " + getCode() + ", message key: " + getMessageKey();
	}

}
