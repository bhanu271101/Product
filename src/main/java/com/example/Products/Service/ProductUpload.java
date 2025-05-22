package com.example.Products.Service;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.Products.Entity.Product;
import com.example.Products.Repository.ProductRepository;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;


@Service
public class ProductUpload {


    @Autowired
    private ProductRepository productRepository;

    public void uploadSheet(MultipartFile file) throws IOException 
    {
        List<Product> productList = new ArrayList<>();

        try (InputStream inputStream = file.getInputStream();
             Workbook workbook = new XSSFWorkbook(inputStream)) {

            Sheet sheet = workbook.getSheetAt(0);
            for (Row row : sheet) {
                if (row.getRowNum() == 0) continue;

                Long id = (long) row.getCell(0).getNumericCellValue();
                String mobileName = row.getCell(1).getStringCellValue();
                String description = row.getCell(2).getStringCellValue();
                double price = row.getCell(3).getNumericCellValue();
                int quantity = (int) row.getCell(4).getNumericCellValue();

                
                Product product=new Product();
                product.setMobileId(id);
                product.setDescreption(description);
                product.setMobileName(mobileName);
                product.setPrice(price);
                product.setQuantity(quantity);
                
                    productList.add(product);
                
                
            }
            productRepository.saveAll(productList);
            
    }

}

           
}
