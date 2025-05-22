package com.example.Products.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Products.Entity.Inventory;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory,Long>
{
    
	
}
