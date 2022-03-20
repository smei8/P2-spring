package com.ers.expensesys2.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

@Entity
@Table(name="request_details")
public class RequestEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="req_id")
	private int reqId;
	
	@Column(name="user_id", nullable=false)
	private int userId;
	
	@Column(name="type", nullable=false)
	private int reqType;

	@Column(name="request_amount", nullable=false)
	private int reqAmount;

	@Column(name="submit_date")
	@CreationTimestamp
	private Date submitDate;

	@Temporal(TemporalType.DATE)
	@Column(name="approve_date")
	private Date approvedDate;
	
	@Column(name="manager")
	private int manager;
	
	@Column(name="status", nullable=false)
	private int reqStatus;

	public RequestEntity() {
		super();
	}

	public RequestEntity(int reqId, int userId, int reqType, int reqAmount, Date submitDate, int manager,
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

	public RequestEntity(int reqId, int userId, int reqType, int reqAmount, Date submitDate, Date approvedDate,
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

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
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

	public Date getApprovedDate() {
		return approvedDate;
	}

	public void setApprovedDate(Date approvedDate) {
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
		return "RequestEntity [reqId=" + reqId + ", userId=" + userId + ", reqType=" + reqType + ", reqAmount="
				+ reqAmount + ", submitDate=" + submitDate + ", approvedDate=" + approvedDate + ", manager=" + manager
				+ ", reqStatus=" + reqStatus + "]";
	}
	
}
