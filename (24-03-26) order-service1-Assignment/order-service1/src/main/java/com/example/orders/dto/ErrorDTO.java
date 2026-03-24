package com.example.orders.dto;

import java.time.LocalDate;

public class ErrorDTO {
	private String message;
	private LocalDate date;
	private String uri;

	public ErrorDTO(String message, LocalDate date, String uri) {
		super();
		this.message = message;
		this.date = date;
		this.uri = uri;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

}
