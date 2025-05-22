//package com.example.Products.Controller;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.example.Products.DTO.InventoryDTO;
//import com.example.Products.DTO.OrderStatusUpdateDTo;
//import com.example.Products.Service.InventoryService;
//
//@RestController
//public class InventoryController {
//
//
//    @Autowired
//    private InventoryService inventoryService;
//
//
//    @PostMapping("/updateOrderStatus")
//    public String orderStatusUpdate(@RequestBody OrderStatusUpdateDTo orderStatusUpdateDTo)
//    {
//        return inventoryService.orderStatusUpdate(orderStatusUpdateDTo);
//    }
//
//    @GetMapping("/getAllProducts")
//    public List<InventoryDTO> getAllProducts()
//    {
//        return inventoryService.getAllProducts();
//    }
//
//
//}
