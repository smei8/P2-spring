package com.ers.expensesys2.entity;

import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="img_upload")
public class FileEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="img_id")
	private int imgId;
	
	@Lob
	@Column(name="img_data")
	private byte[] imgData;
	
	@Column(name="img_name")
	private String imgName;
	
	@Column(name="img_type")
	private String imgType;
	
	@Column(name="req_id")
//	@OneToOne(fetch=FetchType.LAZY)
//	@JoinColumn(name="req_id")
	private int req_id;

	public FileEntity() {
		super();
	}

	public FileEntity(int imgId, byte[] imgData, String imgName, String imgType, int req_id) {
		super();
		this.imgId = imgId;
		this.imgData = imgData;
		this.imgName = imgName;
		this.imgType = imgType;
		this.req_id = req_id;
	}

	
	public FileEntity(int imgId, byte[] imgData, String imgName, String imgType) {
		super();
		this.imgId = imgId;
		this.imgData = imgData;
		this.imgName = imgName;
		this.imgType = imgType;
	}

	public FileEntity(byte[] imgData, String imgName, String imgType) {
		super();
		this.imgData = imgData;
		this.imgName = imgName;
		this.imgType = imgType;
	}

	public int getImgId() {
		return imgId;
	}

	public void setImgId(int imgId) {
		this.imgId = imgId;
	}

	public byte[] getImgData() {
		return imgData;
	}

	public void setImgData(byte[] imgData) {
		this.imgData = imgData;
	}

	public String getImgName() {
		return imgName;
	}

	public void setImgName(String imgName) {
		this.imgName = imgName;
	}

	public String getImgType() {
		return imgType;
	}

	public void setImgType(String imgType) {
		this.imgType = imgType;
	}

	public int getReq_id() {
		return req_id;
	}

	public void setReq_id(int req_id) {
		this.req_id = req_id;
	}

	@Override
	public String toString() {
		return "FileEntity [imgId=" + imgId + ", imgData=" + Arrays.toString(imgData) + ", imgName=" + imgName
				+ ", imgType=" + imgType + ", req_id=" + req_id + "]";
	}
	

}
