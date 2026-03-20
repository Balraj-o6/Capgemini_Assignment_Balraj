package com.hackerrank.restcontrolleradvice.exception;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.hackerrank.restcontrolleradvice.dto.BuzzException;
import com.hackerrank.restcontrolleradvice.dto.FizzBuzzException;
import com.hackerrank.restcontrolleradvice.dto.FizzException;
import com.hackerrank.restcontrolleradvice.dto.GlobalError;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class FizzBuzzExceptionHandler extends ResponseEntityExceptionHandler {

	@ResponseBody
	@ExceptionHandler({FizzBuzzException.class})
	@ResponseStatus(HttpStatus.INSUFFICIENT_STORAGE)
	public GlobalError handleException(FizzBuzzException e) {
		return new GlobalError(e.getMessage(),e.getErrorReason());
	}
	
	@ResponseBody
	@ExceptionHandler({BuzzException.class})
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public GlobalError handleException(BuzzException e) {
		return new GlobalError(e.getMessage(),e.getErrorReason());
	}
	
	@ResponseBody
	@ExceptionHandler({FizzException.class})
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public GlobalError handleException(FizzException e) {
		return new GlobalError(e.getMessage(),e.getErrorReason());
	}
}
