package com.example.Products.Mapper;

import com.example.Products.DTO.InventoryDTO;
import com.example.Products.DTO.OrderDTO;
import com.example.Products.Entity.Inventory;

public class Mapper {

     public InventoryDTO toDTO(Inventory inventory) {
        if (inventory == null) return null;

        InventoryDTO dto = new InventoryDTO();
        dto.setOrderDTO(inventory.getOrderDTO());

        return dto;
    }

    public Inventory toEntity(InventoryDTO dto) {
        if (dto == null) return null;

        Inventory inventory = new Inventory();
        inventory.setOrderDTO(dto.getOrderDTO());
        return inventory;
    }


    public Inventory toInventory(OrderDTO orderDTO) {
        if (orderDTO == null) return null;

        Inventory inventory = new Inventory();
        inventory.setOrderDTO(orderDTO);
        return inventory;
    }

}
