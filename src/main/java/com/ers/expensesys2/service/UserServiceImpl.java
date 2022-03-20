package com.ers.expensesys2.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ers.expensesys2.dao.UserDao;
import com.ers.expensesys2.entity.UserEntity;
import com.ers.expensesys2.pojo.UserPojo;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;
	

	public UserServiceImpl(){
		//userDao = new UserDaoImpl();
	}

	@Override
	public List<UserPojo> fetchAllAccounts() {
		
		List<UserPojo> allUserPojos = new ArrayList<UserPojo>();
		List<UserEntity> allUserEntity = userDao.findAll();
		
		for(UserEntity userEntity: allUserEntity) {
			UserPojo userPojo = new UserPojo(
					userEntity.getUserID(), 
					userEntity.getUsername(), 
					userEntity.getPassword(), 
					userEntity.getFullName(), 
					userEntity.getEmail(), 
					userEntity.getRole_id());
			
			allUserPojos.add(userPojo);
		}
		return allUserPojos;	
	}

	@Override
	public UserPojo fetchAAccount(int userId) {
		
		Optional<UserEntity> optional =  userDao.findById(userId);
		UserPojo userPojo = null;
		
		if(optional.isPresent()) {
			UserEntity userEntity = optional.get();
			userPojo = new UserPojo(
					userEntity.getUserID(), 
					userEntity.getUsername(), 
					userEntity.getPassword(),
					userEntity.getFullName(), 
					userEntity.getEmail(), 
					userEntity.getRole_id());
		}
		return userPojo;
	}

	@Override
	public UserPojo updateAccount(UserPojo userpojo) {
		
		UserEntity userEntity = new UserEntity(
				userpojo.getUserID(),
				userpojo.getUsername(), 
				userpojo.getPassword(), 
				userpojo.getFullName(),
				userpojo.getEmail(),
				userpojo.getRole_id());
		
		userDao.save(userEntity);
		return userpojo;	
	}

	@Override
	public UserPojo login(UserPojo user) {
		UserEntity optional = userDao.findByUsername(user.getUsername());
		UserPojo userPojo = new UserPojo();

		if (optional != null) {
			UserEntity userEntity = optional;
			if (user.getPassword().equals(userEntity.getPassword()) &&
					user.getRole_id() == userEntity.getRole_id()) {
				userPojo = new UserPojo(
						userEntity.getUserID(), 
						userEntity.getUsername(), 
						userEntity.getPassword(),
						userEntity.getFullName(), 
						userEntity.getEmail(), 
						userEntity.getRole_id());
			}
		}
		return userPojo;
	}
}
