package com.ers.expensesys2.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ers.expensesys2.entity.UserEntity;

@Repository("userDao")
@Transactional
public interface UserDao extends JpaRepository<UserEntity, Integer> {

	UserEntity findByUsername(String username);
}
