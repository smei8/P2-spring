package com.ers.expensesys2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ers.expensesys2.exception.SystemException;
import com.ers.expensesys2.pojo.RequestPojo;
import com.ers.expensesys2.service.RequestService;

@RestController
@RequestMapping("api")
@CrossOrigin
public class RequestController {
	
	@Autowired
	RequestService requestService;
	
	// viewAllRequest
	@GetMapping("requests")
	List<RequestPojo> viewAllRequest() throws SystemException {
		return requestService.viewAllRequest();
	}

	//fetch all emp request
	@GetMapping("epRequest/{userId}")
	List<RequestPojo> viewAllEpRequest(@PathVariable("userId") int bid) throws SystemException {
		return requestService.viewAllEpRequest(bid);
	}

	// addRequest
	@PostMapping("requests")
	RequestPojo addRequest(@RequestBody RequestPojo requestPojo) throws SystemException {
		return requestService.addRequest(requestPojo);
	}

	// viewPendingRequest
	@GetMapping("pendings")
	List<RequestPojo> viewPendingRequest() throws SystemException {
		return requestService.viewPendingRequest();
	}

	// reviewRequest
	@PutMapping("requests")
	RequestPojo reviewRequest(@RequestBody RequestPojo requestPojo) throws SystemException {
		return requestService.reviewRequest(requestPojo);
	}

	// fetchARequest
	@GetMapping("requests/{reqId}")
	RequestPojo fetchARequest(@PathVariable("reqId") int bid) throws SystemException {
		return requestService.fetchARequest(bid);
	}

	// deleteRequest
	@DeleteMapping("requests/{reqId}")
	List<RequestPojo> deleteRequest(@PathVariable("reqId") int bid) throws SystemException {
		return requestService.deleteRequest(bid);	
	}
}
