package com.app.API.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.app.API.entity.ImageData;
import com.app.API.entity.Product;
import com.app.API.entity.ProductDTO;

@Mapper
public interface StorageDAO {

	List<ImageData> findAllImages();
	
	int addProduct(Product product);
	
	List<ProductDTO> findAllProducts();
}
