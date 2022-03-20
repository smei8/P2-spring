package com.ers.expensesys2.service;

import java.util.List;

import com.ers.expensesys2.pojo.UserPojo;


public interface UserService {
	
	List<UserPojo> fetchAllAccounts();
	
	UserPojo fetchAAccount(int userId);
	
	UserPojo updateAccount(UserPojo userpojo);
	
	UserPojo login(UserPojo user);
}
