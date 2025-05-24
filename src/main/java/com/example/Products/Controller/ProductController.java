package com.example.Products.Controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.Products.Entity.Product;
import com.example.Products.Service.ProductService;
import com.example.Products.Service.ProductUpload;

@RestController
@RequestMapping("/product")
public class ProductController {



    @Autowired
    private ProductUpload productUpload;


    @Autowired
    private ProductService productService;



    @PostMapping("/upload")
    public String SheetUpload(@RequestParam("file") MultipartFile file) throws IOException
    {
        productUpload.uploadSheet(file);
        return "Products sheet upload successful";
    }

    @GetMapping("/getProductById/{mobileId}")
    public Product getProductById(@PathVariable Long mobileId)
    {
        return productService.getProductById(mobileId);
    }


     @GetMapping("/cronjob")
    public String dummyForCronjob()
    {
        return "Cronjob ran successfully";
    }

    @GetMapping("/getAllProducts")
    public List<Product> getAllProducts()
    {
        return productService.getAllProducts();
    }

    @GetMapping("/getHubId/{mobileId}")
    public Long getHubId(@PathVariable Long mobileId)
    {
        return productService.getHubId(mobileId);
    }

    
}
