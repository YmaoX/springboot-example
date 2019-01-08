package com.maomao.boottest.config;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.maomao.boottest.dto.ErrorDTO;
import com.maomao.boottest.error.BasicException;
import com.maomao.boottest.utils.ErrorCodes;

@SuppressWarnings("static-method")
@ControllerAdvice
public class ControllerExceptionHandler {
	private static final Logger logger = LoggerFactory.getLogger(ControllerExceptionHandler.class);

	@Autowired
	private MessageSource messageSource;

	@ExceptionHandler(BasicException.class)
	public ResponseEntity<ErrorDTO> handle(final BasicException be) {
		try {
			final String s = messageSource.getMessage(be.getMessageKey(), be.getParams(), Locale.ENGLISH);
			logger.error(s, be);
			final ErrorDTO dto = new ErrorDTO(be.getCode(), s);
			return new ResponseEntity<>(dto, HttpStatus.BAD_REQUEST);
		} catch (final Exception e) {
			logger.error("error when handling exception", e);
			logger.error("original exception", be);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorDTO> handle(final MethodArgumentNotValidException e) {
		final ErrorDTO dto = new ErrorDTO(ErrorCodes.COMMON_ERROR_BEAN_VALIDATION, e.getMessage());
		return new ResponseEntity<>(dto, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<ErrorDTO> handle(final RuntimeException be) {
		logger.error("", be);
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}

}
