package com.ers.expensesys2.service;

import java.io.IOException;
import java.util.stream.Stream;

import org.springframework.web.multipart.MultipartFile;

import com.ers.expensesys2.entity.FileEntity;
import com.ers.expensesys2.pojo.FilePojo;


public interface FileStorageService {

	FilePojo store(MultipartFile file, int rid) throws IOException;
	
	FilePojo getFile(int id);
	
	Stream<FileEntity> getAllFiles();
	
}
