package com.example.Products.DTO;

import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.PROPERTY, property = "@class")
public class ImageResponse {
    private Long id;
    private String image;
    
    // Default constructor
    public ImageResponse() {}
    
    // All-args constructor
    public ImageResponse(Long id, String image) {
        this.id = id;
        this.image = image;
    }
    
    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getImage() { return image; }
    public void setImage(String image) { this.image = image; }
}