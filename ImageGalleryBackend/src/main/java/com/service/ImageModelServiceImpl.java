package com.service;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.dao.ImageModelRepository;
import com.model.ImageModel;

@Service
public class ImageModelServiceImpl implements ImageModelService {

	
	@Autowired
	private ImageModelRepository imageRepo;
	
	
	@Override
	public Optional<ImageModel> getFile(Long fileId) {
		
		 return imageRepo.findById(fileId);
	}

	@Override
	public List<ImageModel> getAllFile() {
		
		 return imageRepo.findAll();
	}

	@Override
	public void deleteImageFile(Long fileId) {
		
		imageRepo.deleteById(fileId);
	}

	@Override
	public ImageModel storeFile(MultipartFile file, String title, String description, String category) {
	    ImageModel img = new ImageModel();
	    img.setName(file.getOriginalFilename());
	    img.setTitle(title);
	    img.setDescription(description);
	    img.setCategory(category);
	    img.setUploadedAt(new Date());
	    try {
	        img.setImageData(file.getBytes());
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    return imageRepo.save(img);
	}

	@Override
	public void deleteMultipleImages(List<Long> ids) {
	    imageRepo.deleteAllById(ids);
	}
	@Override
	public List<ImageModel> searchByTitle(String title) {
	    return imageRepo.findByTitleContainingIgnoreCase(title);
	}

	@Override
	public List<ImageModel> filterByCategory(String category) {
	    return imageRepo.findByCategory(category);
	}

	@Override
	public List<ImageModel> sortByUploadDate() {
	    return imageRepo.findAllByOrderByUploadDateAsc();
	}


}




