package com.ers.expensesys2.service;

import java.io.IOException;
import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.ers.expensesys2.dao.FileDao;
import com.ers.expensesys2.entity.FileEntity;
import com.ers.expensesys2.entity.RequestEntity;
import com.ers.expensesys2.pojo.FilePojo;

@Service
public class FileStorageServiceImpl implements FileStorageService {

	@Autowired
	FileDao fileDao;
	
	@Override
	public FilePojo store(MultipartFile file, int rid) throws IOException {
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		
		FileEntity fileEntity = new FileEntity(file.getBytes(), fileName, file.getContentType());
		fileEntity.setReq_id(rid);
		fileDao.saveAndFlush(fileEntity);
		//fileEntity.setReq_id(RequestEntity.getReqId());
		
		FilePojo filePojo = new FilePojo(
				fileEntity.getImgId(),
				fileEntity.getImgData(),
				fileEntity.getImgType(),
				fileEntity.getImgName(),
				fileEntity.getReq_id()); 
				//need to somehow add getReqId from request_details;
		
		return filePojo;
	}

	@Override
	public FilePojo getFile(int id) {
		
		Optional<FileEntity> optional = fileDao.findById(id);
		FilePojo filePojo = null;
		
		if(optional.isPresent()) {
			FileEntity fileEntity = optional.get();
			filePojo = new FilePojo(
					fileEntity.getImgId(),
					fileEntity.getImgData(),
					fileEntity.getImgType(),
					fileEntity.getImgName()
					);
		}
		return filePojo;
	}

	@Override
	public Stream<FileEntity> getAllFiles() {
		return fileDao.findAll().stream();
	}

}
