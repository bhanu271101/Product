package com.example.Products.Service;



import com.example.Products.Entity.ProductImage;
import com.example.Products.Repository.ProductImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductImageService {

    @Autowired
    private ProductImageRepository productImageRepository;

    public ProductImage uploadImage(byte[] imageBytes) throws IOException {
        ProductImage productImage = new ProductImage();
        productImage.setImage(imageBytes);
        return productImageRepository.save(productImage);
    }


    public List<ProductImage> getAllImages()
    {
        return productImageRepository.findAll();
    }


    public List<ProductImage> getImageById(List<Long> ids) {

        List<ProductImage> productImages=new ArrayList<>();
        for(Long id:ids)
        {
            ProductImage productImage=productImageRepository.getById(id);
            productImages.add(productImage);
        }
        return productImages;
    }
}

