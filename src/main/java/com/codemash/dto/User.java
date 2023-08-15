package com.codemash.dto;

public record User(Integer id, String firstname, String lastname) {

	public String fullname() {
		return firstname + " " + lastname;
	}
}
