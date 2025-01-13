package com.tikidev.inventory_service.services;

import com.tikidev.inventory_service.models.dtos.BaseResponse;
import com.tikidev.inventory_service.models.dtos.OrderItemRequest;
import com.tikidev.inventory_service.models.entities.Inventory;
import com.tikidev.inventory_service.repositories.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InventoryService {

    @Autowired
    private InventoryRepository inventoryRepository;


    public boolean isInStock(String sku) {
        var inventory = inventoryRepository.findBySku(sku);

        return inventory.filter(value -> value.getQuantity() > 0).isPresent();
    }

    public BaseResponse areInStock(List<OrderItemRequest> orderItems) {
        var errorList = new ArrayList<String>();
        List<String> skus =  orderItems.stream().map(OrderItemRequest::getSku).toList();
        List<Inventory> inventoryList = inventoryRepository.findBySkuIn(skus);

        orderItems.forEach(orderItem -> {
            var inventory = inventoryList.stream().filter(value -> value.getSku().equals(orderItem.getSku())).findFirst();
            if(inventory.isEmpty()) {
                errorList.add("Product with SKU " + orderItem.getSku() + " not found");
            }else  if(inventory.get().getQuantity() < orderItem.getQuantity()) {
                errorList.add("Product with SKU " + orderItem.getSku() + " has insufficient quantity in stock");
            }
        });
        return  errorList.size() > 0 ? new BaseResponse(errorList.toArray(new String[0])) : new BaseResponse(null);
    }
}
