package com.maomao.boottest.config;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.maomao.boottest.dto.ErrorDTO;
import com.maomao.boottest.error.BasicException;

@ControllerAdvice
public class ControllerExceptionHandler {
	private static final Logger logger = LoggerFactory.getLogger(ControllerExceptionHandler.class);

	@Autowired
	private MessageSource messageSource;

	@ExceptionHandler(BasicException.class)
	public ResponseEntity<ErrorDTO> handle(final BasicException be) {
		final String s = messageSource.getMessage(be.getMessageKey(), be.getParams(), Locale.ENGLISH);
		logger.error(s, be);
		final ErrorDTO dto = new ErrorDTO(be.getCode(), s);
		return new ResponseEntity<>(dto, HttpStatus.BAD_REQUEST);
	}

}