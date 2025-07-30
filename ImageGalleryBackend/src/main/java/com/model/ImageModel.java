package com.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;

@Entity
public class ImageModel {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String name;

    @Lob
    @Column(length = 100000)
    private byte[] imageData;

    private String title;
    private String description;
    private String category;
    private LocalDate uploadDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date uploadedAt = new Date();

    public ImageModel() {
        super();
    }

    public ImageModel(Long id, String name, byte[] imageData) {
        super();
        this.id = id;
        this.name = name;
        this.imageData = imageData;
    }

    

    public String getTitle() { return title; }
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public byte[] getImageData() {
		return imageData;
	}

	public void setImageData(byte[] imageData) {
		this.imageData = imageData;
	}

	public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public Date getUploadedAt() { return uploadedAt; }
    public void setUploadedAt(Date uploadedAt) { this.uploadedAt = uploadedAt; }

  
}
