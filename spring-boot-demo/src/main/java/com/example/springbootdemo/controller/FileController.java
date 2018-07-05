package com.example.springbootdemo.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.springbootdemo.data.FileInfo;

@RestController
@RequestMapping("/file")
public class FileController {
	Logger LOGGER = LoggerFactory.getLogger(FileController.class);
	private String path = "d:\\";

	@PostMapping
	public FileInfo upload(MultipartFile file) throws IllegalStateException, IOException {
		LOGGER.debug("File Name:" + file.getName());
		LOGGER.debug("File OriginalName:" + file.getOriginalFilename());
		LOGGER.debug("File Size:" + String.valueOf(file.getSize()));

		File localFile = new File(path, file.getOriginalFilename());

		file.transferTo(localFile);

		return new FileInfo(localFile.getAbsolutePath());
	}

	@GetMapping("/{id}")
	public void download(@PathVariable String id, HttpServletRequest request, HttpServletResponse response) {
		try (InputStream inputStream = new FileInputStream(new File(path, id + ".jpg"));
				OutputStream outputStream = response.getOutputStream();) {

			response.setContentType("application/x-download");
			response.addHeader("Content-Disposition", "attachment;filename=" + id + ".jpg");

			IOUtils.copy(inputStream, outputStream);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
