package com.example.Products.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.cache.annotation.Cacheable;
import com.example.Products.Entity.Product;
import com.example.Products.Exception.ProductNotFoundException;
import com.example.Products.Repository.ProductRepository;

@Service
public class ProductService {


    @Autowired
    private ProductRepository productRepository;



            public Product getProductById(Long Id)
            {
                
                Product product=productRepository.findByMobileId(Id);
                if(product==null)
                {
                  throw new ProductNotFoundException("Product not found");
                }
                else
                {
                    double discount=product.getDiscount();
                    double discountAmount=product.getPrice()*(discount/100);
                    double price=product.getPrice()-discountAmount;
                    product.setPrice(price);
                    return product;
                }
                
                
            }


            @Cacheable(value = "products")
            public List<Product> getAllProducts()
            {
                System.out.println("printing from DB");
                return productRepository.findAll();
            }


            public Long getHubId(Long mobileId)
            {
                Product product=productRepository.findByMobileId(mobileId);
                return product.getHubId();
            }


}
