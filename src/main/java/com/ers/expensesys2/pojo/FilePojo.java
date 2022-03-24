package com.ers.expensesys2.pojo;

import java.util.Arrays;

public class FilePojo {

	private int imgId;
	private byte[] imgData;
	private String imgName;
	private String imgType;
	private int reqId;
	
	public FilePojo() {
		super();
	}

	public FilePojo(int imgId, byte[] imgData, String imgName, String imgType, int reqId) {
		super();
		this.imgId = imgId;
		this.imgData = imgData;
		this.imgName = imgName;
		this.imgType = imgType;
		this.reqId = reqId;
	}

	public FilePojo(int imgId, byte[] imgData, String imgName, String imgType) {
		super();
		this.imgId = imgId;
		this.imgData = imgData;
		this.imgName = imgName;
		this.imgType = imgType;
	}

	public FilePojo(byte[] imgData, String imgName, String imgType) {
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

	public int getReqId() {
		return reqId;
	}

	public void setReqId(int reqId) {
		this.reqId = reqId;
	}

	@Override
	public String toString() {
		return "FilePojo [imgId=" + imgId + ", imgData=" + Arrays.toString(imgData) + ", imgName=" + imgName
				+ ", imgType=" + imgType + ", reqId=" + reqId + "]";
	}
	
}
