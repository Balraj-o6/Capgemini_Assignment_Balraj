package com.example.orders.exception;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.orders.dto.ErrorDTO;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(OrderNotFoundException.class)
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	public ErrorDTO handleOrderNotFoundException(OrderNotFoundException e, HttpServletRequest request) {
		return new ErrorDTO("Order not found",LocalDate.now(),request.getRequestURI());
	}
    
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public Map<String,List<String>> handleValidationError(MethodArgumentNotValidException e) {
		List<String> errors = new ArrayList<String>();
		for(FieldError error: e.getBindingResult().getFieldErrors()) {
			errors.add(error.getDefaultMessage());
		}
		Map<String,List<String>> response = new HashMap<String, List<String>>();
		response.put("errors", errors);
		return response;
	}
}
