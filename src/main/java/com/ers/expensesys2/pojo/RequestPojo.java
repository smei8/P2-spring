package com.ers.expensesys2.pojo;

import java.util.Date;

public class RequestPojo {

	private int reqId;
	private int userId;
	private int reqType;
	private int reqAmount;
	private Date submitDate;
	private Date approvedDate;
	private int manager;
	private int reqStatus;
	
	public RequestPojo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RequestPojo(int userId, int reqType, int reqAmount, int manager) {
		super();
		this.userId = userId;
		this.reqType = reqType;
		this.reqAmount = reqAmount;
		this.manager = manager;
	}

	public RequestPojo(int reqId, int userId, int reqType, int reqAmount, int manager, int reqStatus) {
		super();
		this.reqId = reqId;
		this.userId = userId;
		this.reqType = reqType;
		this.reqAmount = reqAmount;
		this.manager = manager;
		this.reqStatus = reqStatus;
	}

	
	public RequestPojo(int reqId, int userId, int reqType, int reqAmount, Date submitDate, int manager,
			int reqStatus) {
		super();
		this.reqId = reqId;
		this.userId = userId;
		this.reqType = reqType;
		this.reqAmount = reqAmount;
		this.submitDate = submitDate;
		this.manager = manager;
		this.reqStatus = reqStatus;
	}

	public RequestPojo(int reqId, int userId, int reqType, int reqAmount, Date submitDate, Date approvedDate,
			int manager, int reqStatus) {
		super();
		this.reqId = reqId;
		this.userId = userId;
		this.reqType = reqType;
		this.reqAmount = reqAmount;
		this.submitDate = submitDate;
		this.approvedDate = approvedDate;
		this.manager = manager;
		this.reqStatus = reqStatus;
	}

	public int getReqId() {
		return reqId;
	}

	public void setReqId(int reqId) {
		this.reqId = reqId;
	}

	public int getuserId() {
		return userId;
	}

	public void setuserId(int userId) {
		this.userId = userId;
	}

	public int getReqType() {
		return reqType;
	}

	public void setReqType(int reqType) {
		this.reqType = reqType;
	}

	public int getReqAmount() {
		return reqAmount;
	}

	public void setReqAmount(int reqAmount) {
		this.reqAmount = reqAmount;
	}

	public Date getSubmitDate() {
		return submitDate;
	}

	public void setSubmitDate(Date submitDate) {
		this.submitDate = submitDate;
	}

	public Date getapprovedDate() {
		return approvedDate;
	}

	public void setapprovedDate(Date approvedDate) {
		this.approvedDate = approvedDate;
	}

	public int getManager() {
		return manager;
	}

	public void setManager(int manager) {
		this.manager = manager;
	}

	public int getReqStatus() {
		return reqStatus;
	}

	public void setReqStatus(int reqStatus) {
		this.reqStatus = reqStatus;
	}

	@Override
	public String toString() {
		return "RequestPojo [reqId=" + reqId + ", userId=" + userId + ", reqType=" + reqType + ", reqAmount=" + reqAmount
				+ ", submitDate=" + submitDate + ", approvedDate=" + approvedDate + ", manager=" + manager
				+ ", reqStatus=" + reqStatus + "]";
	}
}
