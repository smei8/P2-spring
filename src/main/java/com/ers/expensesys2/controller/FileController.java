package com.ers.expensesys2.controller;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ers.expensesys2.message.ResponseFile;
import com.ers.expensesys2.message.ResponseMessage;
import com.ers.expensesys2.pojo.FilePojo;
import com.ers.expensesys2.service.FileStorageService;


@Controller
//@RequestMapping("api")
@CrossOrigin
public class FileController {

	@Autowired
	private FileStorageService storageService;
	
	@PostMapping("/upload/{rid}")
	public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file, @PathVariable int rid) {
		String message = "";
		
		try {
			storageService.store(file, rid);
			message = "Uploaded the file successfully: " + file.getOriginalFilename();
			return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
		} catch (Exception e) {
			message = "Could not upload the file: " + file.getOriginalFilename();
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
		}
	}
	
	@GetMapping("/files")
	public ResponseEntity<List<ResponseFile>> getListFiles() {
		List<ResponseFile> files = storageService.getAllFiles().map(dbFile -> {
			String fileDownloadUri = ServletUriComponentsBuilder
					.fromCurrentContextPath()
					.path("/files/")
					.path(Integer.toString(dbFile.getImgId()))
					.toUriString();
			
			return new ResponseFile(
					dbFile.getImgName(), 
					fileDownloadUri, 
					dbFile.getImgType(),
					dbFile.getImgData().length);
		}).collect(Collectors.toList());
		return ResponseEntity.status(HttpStatus.OK).body(files);
	}
	
	@GetMapping("/files/{id}")
	public ResponseEntity<byte[]> getFile(@PathVariable int id) {
		FilePojo filePojo = storageService.getFile(id);
		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attchment; filename=\"" + filePojo.getImgName() + "\"")
				.body(filePojo.getImgData());
	}
}
