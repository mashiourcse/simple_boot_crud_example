package com.codemash.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.codemash.dto.User;
import com.codemash.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/crud")
@RequiredArgsConstructor
public class CrudController {
	
	private final UserService userService;
	
	
	@GetMapping("")
	public List<User> getUsers(){
		return userService.getUsers();
	}
	
	@GetMapping("/{id}")
	public User getUserById( @PathVariable Integer id){
		return userService.getUserById(id);
	}
	
	@PostMapping("")
	public List<User> createUser(@RequestBody User user) {
		
		return userService.createUser(user);
	}
	
	@DeleteMapping("")
	public String deleteUser(@RequestBody User user) {
		
		return userService.deleteUser(user);
	}
	
	@PutMapping("")
	public List<User> putUser(@RequestBody User user) {
		
		return userService.putUser(user);
	}
	
	@PatchMapping("")
	public List<User> patchUser(@RequestBody User user) {
		
		return userService.patchUser(user);
	}
	
}
