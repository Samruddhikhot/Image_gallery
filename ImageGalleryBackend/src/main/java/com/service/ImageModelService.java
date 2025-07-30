package com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.web.multipart.MultipartFile;

import com.model.ImageModel;

public interface ImageModelService {

	public ImageModel storeFile(MultipartFile file, String title, String description, String category);

	
	public Optional<ImageModel> getFile(Long fileId);
	public List<ImageModel> getAllFile( );
	public void deleteImageFile(Long fileId);


	public void deleteMultipleImages(List<Long> ids);
	
	List<ImageModel> searchByTitle(String title);
	List<ImageModel> filterByCategory(String category);
	List<ImageModel> sortByUploadDate();

}
