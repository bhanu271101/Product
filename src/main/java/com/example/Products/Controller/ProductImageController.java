package com.example.Products.Controller;

import com.example.Products.DTO.ImageResponse;
import com.example.Products.Entity.ProductImage;
import com.example.Products.Service.ProductImageService;

import org.hibernate.annotations.Cache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@RestController
public class ProductImageController {

    @Autowired
    private ProductImageService productImageService;

    @PostMapping("/upload")
    public ResponseEntity<String> uploadImage(@RequestParam("file") MultipartFile file) {
        try {
            // Convert MultipartFile to byte array
            byte[] imageBytes = file.getBytes();

            // Save image in the database
            ProductImage productImage = productImageService.uploadImage(imageBytes);

            // Return success response
            return ResponseEntity.ok("Image uploaded successfully! Image ID");

        } catch (IOException e) {
            return ResponseEntity.status(500).body("Failed to upload image: " + e.getMessage());
        }
    }

    @GetMapping("/images")
    public ResponseEntity<List<Map<String, Object>>> getAllImages() {
        List<ProductImage> images = productImageService.getAllImages();
    
        // Convert ProductImage entities to a Map of id and image URL
        List<Map<String, Object>> imageList = images.stream()
                .map(image -> {
                    Map<String, Object> map = new HashMap<>();
                    map.put("id", image.getId());
                    // You can include a URL that will allow Postman to fetch the image by ID
                    map.put("imageUrl", "https://product-0gme.onrender.com/images/" + image.getId());
                    return map;
                })
                .collect(Collectors.toList());
    
        return ResponseEntity.ok(imageList);
    }
    
    @GetMapping("/imagesByIds")
    @Cacheable(value = "productImages", key = "T(java.lang.String).join(',', #ids.![#this.toString()])")
    public List<ImageResponse> getImagesByIds(@RequestParam("mobileId") List<Long> ids) {
        System.out.println("Printing images from DB");
        List<ProductImage> productImages = productImageService.getImageById(ids);

        if (productImages.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Images not found");
        }

        return productImages.stream()
                .map(img -> new ImageResponse(
                        img.getId(),
                        Base64.getEncoder().encodeToString(img.getImage()))
                )
                .collect(Collectors.toList());
    }
    
    
    


}

