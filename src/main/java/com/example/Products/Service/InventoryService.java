//package com.example.Products.Service;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.ListIterator;
//
//import org.springframework.amqp.rabbit.annotation.RabbitListener;
//import org.springframework.amqp.rabbit.core.RabbitTemplate;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.cache.annotation.CacheEvict;
//import org.springframework.cache.annotation.Cacheable;
//import org.springframework.stereotype.Service;
//
//import com.example.Products.DTO.InventoryDTO;
//import com.example.Products.DTO.OrderDTO;
//import com.example.Products.DTO.OrderStatusUpdateDTo;
//import com.example.Products.Entity.Inventory;
//import com.example.Products.Entity.Product;
//import com.example.Products.Mapper.Mapper;
//import com.example.Products.Repository.InventoryRepository;
//import com.example.Products.Repository.ProductRepository;
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//
//
//@Service
//public class InventoryService {
//
//
//    @Autowired
//    private ProductRepository productRepository;
//
//    @Autowired
//    private InventoryRepository inventoryRepository;
//
//    @Autowired
//    private RabbitTemplate rabbitTemplate;
//
//
//    
//    private final Mapper mapper= new Mapper();
//
//    
//            @RabbitListener(queues="inventory.queue")
//            public void stockUpdate(OrderDTO orderDto) 
//            {
//                
//                Long mobileId=orderDto.getMobileId();
//                int quantity=orderDto.getQuantity();
//                Product product=productRepository.findByMobileId(mobileId);
//                int newQuantity=product.getQuantity()-quantity;
//                product.setQuantity(newQuantity);
//                productRepository.save(product);
//                Inventory inventory=mapper.toInventory(orderDto);
//                inventoryRepository.save(inventory);
//               
//            }
//
////            @CacheEvict(value="Inevntory")
////            public String orderStatusUpdate(OrderStatusUpdateDTo orderStatusUpdateDTo)
////            {
////                Inventory inventory=inventoryRepository.findByOrderId(orderStatusUpdateDTo.getOrderId());
////            
////                inventoryRepository.save(inventory);
////                rabbitTemplate.convertAndSend("order-exchange","order.queue",orderStatusUpdateDTo);
////                return "Status updated successfully";
////            }
//
//
//            @Cacheable(value="Inventory")
//            public List<InventoryDTO> getAllProducts()
//            {
//                List<Inventory> inventorys=inventoryRepository.findAll();
//                List<InventoryDTO> inventoryDTOs= new ArrayList<>();
//                ListIterator<Inventory> listIterator=inventorys.listIterator();
//                while(listIterator.hasNext())
//                {
//                    InventoryDTO inventoryDTO=mapper.toDTO(listIterator.next());
//                    inventoryDTOs.add(inventoryDTO);
//                }
//                return inventoryDTOs;
//                
//            }
//
//}
