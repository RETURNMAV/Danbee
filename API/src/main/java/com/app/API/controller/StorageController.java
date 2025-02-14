package com.app.API.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.app.API.entity.Product;
import com.app.API.entity.ProductDTO;
import com.app.API.service.StorageService;


@Controller
public class StorageController {
	
	@Autowired
	private StorageService service;

//	@GetMapping("/view-image/{fileName}")
//    public String showImage(@RequestParam(value = "fileName", required = false) String fileName, Model model) {
//		System.out.println("And then this is: " + fileName);
//        if (fileName != null && !fileName.isEmpty()) {
//            model.addAttribute("imageFileName" + fileName); // Adjust endpoint accordingly
//        }
//        return "image-view"; // Name of the Thymeleaf template (image-view.html)
//    }
	
	@GetMapping("view-image")
	public String findAllImages(Model model) {
//		List<ImageData> list = service.findAllImages();
//		System.out.println("Controller: !!" + list);
//		model.addAttribute("list", list);
		
		List<ProductDTO> plist = service.findAllProducts();
		System.out.println(plist);
		model.addAttribute("list", plist);
		return "image-view";
	}
	
	@PostMapping("/postImage")
	public String uploadImage(@RequestParam("image") MultipartFile file,
			Product product,
			Model model) throws IOException {

		int r = service.addProduct(product, file);
		
//		model.addAttribute("message", uploadMessage);
		return "redirect:view-image";
	}
	
	@GetMapping("addProduct")
	public String addProduct() {
		return "addProduct";
	}
	
	
	//Pages
	@GetMapping("index")
	public String index() {
		return "index";
	}
	
	@GetMapping("about")
	public String about() {
		return "about";
	}
	
	@GetMapping("blog")
	public String blog() {
		return "blog";
	}
	
	@GetMapping("blog-details")
	public String blogDetails() {
		return "blog-details";
	}
	
	@GetMapping("contact")
	public String contact() {
		return "contact";
	}
	
	@GetMapping("image-view")
	public String imageView() {
		return "image-view";
	}
	
	@GetMapping("portfolio")
	public String portfolio() {
		return "portfolio";
	}
	
	@GetMapping("portfolio-details")
	public String portfolioDetails() {
		return "portfolio-details";
	}
	
	@GetMapping("pricing")
	public String pricing() {
		return "pricing";
	}
	
	@GetMapping("service-details")
	public String serviceDetails() {
		return "service-details";
	}
	
	@GetMapping("services")
	public String services() {
		return "services";
	}
	
	@GetMapping("login")
	public String login() {
		return "login";
	}
	
	@GetMapping("team")
	public String team() {
		return "team";
	}
	
	@GetMapping("testimonials")
	public String testimonials() {
		return "testimonials";
	}

	
}
