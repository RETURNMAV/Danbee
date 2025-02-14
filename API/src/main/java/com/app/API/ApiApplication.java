package com.app.API;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.app.API.service.StorageService;

@SpringBootApplication
@RestController
@RequestMapping("/image")
public class ApiApplication {

	@Autowired
	private StorageService service;
	
//	@PostMapping
//	public ResponseEntity<?> uploadImage(@RequestParam("image") MultipartFile file) throws IOException {
//		System.out.println("Hello?");
//		String uploadImage = service.uploadImage(file);
//		System.out.println("UPLOAD IMAGE: " + uploadImage);
//		System.out.println("WHAT'S THIS?" + ResponseEntity.status(HttpStatus.OK).body(uploadImage));
//		return ResponseEntity.status(HttpStatus.OK).body(uploadImage);
//	}
//	
	@GetMapping("/{pid}")
	public ResponseEntity<?> downloadImage(@PathVariable("pid") int pid, Model model) {
		System.out.println("This is: " + pid);
		byte[] imageData = service.downloadImage(pid);
		return ResponseEntity.status(HttpStatus.OK)
				.contentType(MediaType.valueOf("image/png"))
				.body(imageData);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
	}

}
