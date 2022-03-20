package com.ers.expensesys2.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ers.expensesys2.dao.RequestDao;
import com.ers.expensesys2.entity.RequestEntity;
import com.ers.expensesys2.exception.SystemException;
import com.ers.expensesys2.pojo.RequestPojo;

@Service
public class RequestServiceImpl implements RequestService {

	@Autowired
	RequestDao requestDao;
	
	public RequestServiceImpl() {
		//requestDao = new RequestDaoImpl();
	}

	@Override
	public List<RequestPojo> viewAllRequest() throws SystemException {
		
		List<RequestPojo> allRequestPojo = new ArrayList<RequestPojo>();
		List<RequestEntity> allRequestEntity = requestDao.findAll();
		
		for(RequestEntity requestEntity : allRequestEntity) {
			RequestPojo requestPojo = new RequestPojo(
					requestEntity.getReqId(),
					requestEntity.getUserId(),
					requestEntity.getReqType(),
					requestEntity.getReqAmount(),
					requestEntity.getSubmitDate(),
					requestEntity.getApprovedDate(),
					requestEntity.getManager(),
					requestEntity.getReqStatus());
			
			allRequestPojo.add(requestPojo);
		}
		return allRequestPojo;
	}

	@Override
	public RequestPojo addRequest(RequestPojo requestPojo) throws SystemException {
		RequestEntity requestEntity = new RequestEntity(
				requestPojo.getReqId(), 
				requestPojo.getuserId(),
				requestPojo.getReqType(), 
				requestPojo.getReqAmount(),
				requestPojo.getSubmitDate(),
				requestPojo.getManager(),
				requestPojo.getReqStatus());
		
		requestDao.saveAndFlush(requestEntity);
		requestPojo = new RequestPojo(
				requestEntity.getReqId(),
				requestEntity.getUserId(), 
				requestEntity.getReqType(),
				requestEntity.getReqAmount(), 
				requestEntity.getManager(),
				requestEntity.getReqStatus());
		return requestPojo;
	}

	@Override
	public List<RequestPojo> viewPendingRequest() throws SystemException {
		
		List<RequestEntity> allRequestEntity = requestDao.findByReqStatus(1);
		List<RequestPojo> allRequestPojo = new ArrayList<RequestPojo>();
		
		for (RequestEntity requestEntity : allRequestEntity) {
			RequestPojo requestPojo = new RequestPojo(
					requestEntity.getReqId(),
					requestEntity.getUserId(),
					requestEntity.getReqType(),
					requestEntity.getReqAmount(),
					requestEntity.getSubmitDate(),
					requestEntity.getManager(),
					requestEntity.getReqStatus());
			allRequestPojo.add(requestPojo);
		}
		return allRequestPojo;
	}

	@Override
	public RequestPojo reviewRequest(RequestPojo requestPojo) throws SystemException {
		
		Optional<RequestEntity> optional = requestDao.findById(requestPojo.getReqId());
		RequestPojo requsetPojo = null;
		RequestEntity requestEntity = new RequestEntity();
		
		if (optional.isPresent()) {
			requestEntity = optional.get();
			requestEntity.setReqStatus(requestPojo.getReqStatus());
			requestEntity = requestDao.save(requestEntity);
			requsetPojo = new RequestPojo(
					requestEntity.getReqId(), 
					requestEntity.getUserId(),
					requestEntity.getReqType(), 
					requestEntity.getReqAmount(), 
					requestEntity.getSubmitDate(),
					requestEntity.getApprovedDate(),
					requestEntity.getManager(), 
					requestEntity.getReqStatus());
		}
		return requsetPojo;
	}

	@Override
	public List<RequestPojo> deleteRequest(int reqId) throws SystemException {
		requestDao.deleteById(reqId);
		return viewAllRequest();
	}

	@Override
	public RequestPojo fetchARequest(int reqId) throws SystemException {
		Optional<RequestEntity> optional = requestDao.findById(reqId);
		RequestPojo requestPojo = null;
		
		if(optional.isPresent()) {
			RequestEntity requestEntity = optional.get();
			requestPojo = new RequestPojo(
					requestEntity.getReqId(), 
					requestEntity.getUserId(),
					requestEntity.getReqType(), 
					requestEntity.getReqAmount(), 
					requestEntity.getSubmitDate(),
					requestEntity.getApprovedDate(),
					requestEntity.getManager(), 
					requestEntity.getReqStatus());
		}
		return requestPojo;
	}

	@Override
	public List<RequestPojo> viewAllEpRequest(int userId) throws SystemException {
		
		List<RequestEntity> allRequestEntity = requestDao.findByUserId(userId);
		List<RequestPojo> allRequestPojo = new ArrayList<RequestPojo>();
		
		for (RequestEntity requestEntity : allRequestEntity) {
			RequestPojo requestPojo = new RequestPojo(
					requestEntity.getReqId(),
					requestEntity.getUserId(),
					requestEntity.getReqType(),
					requestEntity.getReqAmount(),
					requestEntity.getSubmitDate(),
					requestEntity.getApprovedDate(),
					requestEntity.getManager(),
					requestEntity.getReqStatus());
			allRequestPojo.add(requestPojo);
		}
		return allRequestPojo;
	}

}
