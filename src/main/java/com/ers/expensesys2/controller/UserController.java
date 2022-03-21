package com.ers.expensesys2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ers.expensesys2.pojo.UserPojo;
import com.ers.expensesys2.service.UserService;

@RestController
@RequestMapping("api")
@CrossOrigin
public class UserController {
	
	@Autowired
	UserService userService;

	// fetchAllAccount
	@GetMapping("accounts")
	List<UserPojo> fetchAllAccounts() {
		return userService.fetchAllAccounts();
	}
	
	// fetchAAccount
	@GetMapping("accounts/{userID}")
	UserPojo fetchAAccount(@PathVariable("userID") int bid) {
		return userService.fetchAAccount(bid);
	}
	
	// updateAccount
	@PutMapping("accounts")
	UserPojo updateAccount(@RequestBody UserPojo userpojo) {
		return userService.updateAccount(userpojo);
	}
	
	//login
	@PostMapping(value="login", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	UserPojo login(@RequestBody UserPojo user) {
		return userService.login(user);
	}
	
}
