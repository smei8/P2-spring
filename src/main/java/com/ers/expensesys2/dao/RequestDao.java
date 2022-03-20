package com.ers.expensesys2.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ers.expensesys2.entity.RequestEntity;

@Repository("requestDao")
@Transactional
public interface RequestDao extends JpaRepository<RequestEntity, Integer> {

	List<RequestEntity> findByReqStatus(int reqStatus);
	List<RequestEntity> findByUserId(int userId);
	
}
