package com.codemash.controller;

import com.codemash.dto.User;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	@GetMapping("/user")
	public String getUser() {
		return "User";
	}
	
	@GetMapping("/user1/{firstname}/{lastname}")
	// http://localhost:8080/user1/mashiour/rahman
	public String getUser1(@PathVariable("firstname") String firstname, @PathVariable("lastname") String lastname) {
		User user = new User(1, firstname, lastname);
		return user.fullname();
	}
	
	@GetMapping("user2")
	// http://localhost:8080/user2?firstname=Sayem&lastname=Chowdhury
	public String getUser2(
			@RequestParam( value = "firstname", defaultValue = "mash", required = false) String firstname,
			@RequestParam( value = "lastname", defaultValue = "X", required = false) String lastname
			) {
		User user = new User( 2, firstname, lastname);
		return user.fullname();
	}
	
	@GetMapping("user3")
	// http://localhost:8080/user3
	public String getUser3(
			@RequestBody( required = true) String name
			) {
		
		return name;
	}
	
	@GetMapping("user4")
	// http://localhost:8080/user4
	public User getUser4(
			@RequestBody( required = true) User user
			) {
		
		return user;
	}
	
	@RequestMapping(path = "getrequestmapping", method = RequestMethod.GET)
	// http://localhost:8080/getmapping/getrequestmapping
	public String getRequestMapping() {
		return "Willy De Keyser";
	}
	
	@GetMapping("getresponseentityok")
	// http://localhost:8080/getmapping/getresponseentityok
	public ResponseEntity<String> getResponseEntiyok() {
		return new ResponseEntity<>("Willy De Keyser", HttpStatus.OK);
	}
	
	@GetMapping("getresponseentitytimeout")
	// http://localhost:8080/getmapping/getresponseentitytimeout
	public ResponseEntity<String> getResponseEntiyTimeogut() {
		return new ResponseEntity<>("Time out", HttpStatus.REQUEST_TIMEOUT);
	}
	
	@GetMapping("getVoid")
	// http://localhost:8080/getmapping/void
	public void getvoid() {
	}
	
}