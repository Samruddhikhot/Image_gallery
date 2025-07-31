package com.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.model.ImageModel;
import com.service.ImageModelService;

@RestController
@CrossOrigin(origins = "https://willowy-biscotti-f1deef.netlify.app")
public class ImageController {

	@Autowired
	private ImageModelService imageService;
	


	@PostMapping("/upload")
	public ResponseEntity<String> addFile(
	    @RequestParam("file") MultipartFile file,
	    @RequestParam("title") String title,
	    @RequestParam("description") String description,
	    @RequestParam("category") String category) {

	    ImageModel img = imageService.storeFile(file, title, description, category);
	    return ResponseEntity.ok("Image added successfully: " + img.getName());
	}

	
	@GetMapping("/getAll")
	public ResponseEntity<List<ImageModel>> getAllFile(){
		
		List<ImageModel> imgList=imageService.getAllFile();
		return ResponseEntity.status(HttpStatus.OK).header("getAll", "get all images").body(imgList);
		// return new ResponseEntity<>(imgList, HttpStatus.OK);
		
		/*List<ImageModel> files = imageService.getAllFile();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Custom-Header", "All files retrieved");

        return new ResponseEntity<>(files, headers, HttpStatus.OK);*/
	}
	
	@GetMapping("/getOne/{id}")
	public ResponseEntity<Resource> getOneFile(@PathVariable Long id){
		
		Optional<ImageModel> imageOptional = imageService.getFile(id);
		 ImageModel image = imageOptional.get();
		return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + image.getName() + "\"")
                .body(new ByteArrayResource(image.getImageData()));
  

	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteImage(@PathVariable Long id) {
	    imageService.deleteImageFile(id);
	    return ResponseEntity.ok("Image deleted successfully with ID: " + id);
	}
	
	@DeleteMapping("/deleteAll")
	public ResponseEntity<String> deleteMultiple(@RequestBody List<Long> ids) {
	    imageService.deleteMultipleImages(ids);
	    return ResponseEntity.ok("Images deleted successfully.");
	}

	
	@GetMapping("/search")
	public ResponseEntity<List<ImageModel>> searchByTitle(@RequestParam String title) {
	    return ResponseEntity.ok(imageService.searchByTitle(title));
	}

	@GetMapping("/filter")
	public ResponseEntity<List<ImageModel>> filterByCategory(@RequestParam String category) {
	    return ResponseEntity.ok(imageService.filterByCategory(category));
	}

	@GetMapping("/sort")
	public ResponseEntity<List<ImageModel>> sortByDate() {
	    return ResponseEntity.ok(imageService.sortByUploadDate());
	}

	
}
