package com.codemash.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.codemash.dto.User;

@Service
public class UserService {

	private static List<User> users = new ArrayList<>();
	
	public List<User> getUsers(){
		return users;
	}
	
	public User getUserById( Integer id) {
		
		return users.stream().filter( user -> user.id().equals(id)).findFirst().orElse(null);	
		
	}
	
	public List<User> createUser( User user) {
		List<User> usersTemp = new ArrayList<>(users);
		usersTemp.add(user);
		users = usersTemp;
		return users;
	}
	
	public String deleteUser( User user) {
		
		List<User> userTemp = users.stream()
								   .filter( u -> u.id() != user.id())
								   .toList();
		users = userTemp;
		return "User deleted with id: " + user.id(); 
	}
	
	public List<User> putUser( User user) {
		
		List<User> usersTemp = users.stream()
								   .map( (u) -> {
									
									   if( u.id() == user.id()) {
										   return u = new User( user.id(), user.firstname(), user.lastname());
									   }
									   return u;
								   })
								   .toList();
		users = usersTemp;
		
		return users;
	}
	
	public List<User> patchUser( User user) {
		
		List<User> usersTemp = users.stream()
								   .map( (u) -> {
									
									   if( u.id() == user.id()) {
										   return u = new User( user.id(), user.firstname(), user.lastname());
									   }
									   return u;
								   })
								   .toList();
		users = usersTemp;
		
		return users;
	}

}
