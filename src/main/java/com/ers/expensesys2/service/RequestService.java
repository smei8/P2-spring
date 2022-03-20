package com.ers.expensesys2.service;

import java.util.List;

import com.ers.expensesys2.exception.SystemException;
import com.ers.expensesys2.pojo.RequestPojo;

public interface RequestService {
	//view all request doesnt matter of the status
	List<RequestPojo> viewAllRequest() throws SystemException;
	
	List<RequestPojo> viewAllEpRequest(int userId) throws SystemException;
	
	RequestPojo addRequest(RequestPojo requestPojo) throws SystemException;
	
	//view pending request
	List<RequestPojo> viewPendingRequest() throws SystemException;
	
	//manage to review and either approve, denied the request
	RequestPojo reviewRequest(RequestPojo requestPojo) throws SystemException;
	
	RequestPojo fetchARequest(int reqId) throws SystemException;
	
	List<RequestPojo> deleteRequest(int reqId) throws SystemException;
}
