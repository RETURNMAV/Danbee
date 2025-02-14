package com.app.API.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.app.API.dao.StorageDAO;
import com.app.API.entity.ImageData;
import com.app.API.entity.ImageUtils;
import com.app.API.entity.Product;
import com.app.API.entity.ProductDTO;
import com.app.API.repository.StorageRepository;

import jakarta.transaction.Transactional;

@Service
public class StorageService {

	@Autowired
	private StorageRepository repository;
	
	@Autowired
	private StorageDAO dao;
	
	private static final String IMAGE_DIRECTORY = "C:/SpringBoot/uploads";
//	
//	public String uploadImage(MultipartFile file) throws IOException {
//		ImageData imageData = repository.save(ImageData.builder()
//				.name(file.getOriginalFilename())
//				.type(file.getContentType())
//				.imageData(ImageUtils.compressImage(file.getBytes())).build());
//		
//		if (imageData != null) {
//			System.out.println("file uploaded successfuly: " + imageData.getName());
//			return "file uploaded successfully: " + imageData.getName();
//		}
//		return "failed to upload file";
//	}
	
	public byte[] downloadImage(int pid) {
		Optional<ImageData> dbImageData = repository.findById(pid);
		byte[] images = ImageUtils.decompressImage(dbImageData.get().getImageData());
		
		return images;
	}
	
	public List<ImageData> findAllImages() {
		List<ImageData> list = new ArrayList<>();
		list = dao.findAllImages();
		System.out.println("Service!!: " +list);
		
		return list;
	}
	
	@Transactional
	public int addProduct(Product product, MultipartFile file) throws IOException  {
		
		ImageData imageData =ImageData.builder()
				.name(file.getOriginalFilename())
				.type(file.getContentType())
				.imageData(ImageUtils.compressImage(file.getBytes())).build();
		
		imageData = repository.save(imageData);
		
		System.out.println("Uploading product info is: " + product);
		
		int r = dao.addProduct(product);
		if(r>=1) {
			System.out.println("UPLOADED");
		}else {
			System.out.println("NO");
		}
		return r;
	}
	
	public List<ProductDTO> findAllProducts() {
		List<ProductDTO> plist = dao.findAllProducts();
		System.out.println("plist is: " + plist);
		return plist;
	}
} 
