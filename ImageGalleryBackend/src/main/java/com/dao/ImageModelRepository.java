package com.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.model.ImageModel;

public interface ImageModelRepository extends JpaRepository<ImageModel,Long> {
	
	List<ImageModel> findByTitleContainingIgnoreCase(String title);
    List<ImageModel> findByCategory(String category);
    List<ImageModel> findAllByOrderByUploadDateAsc();

}
