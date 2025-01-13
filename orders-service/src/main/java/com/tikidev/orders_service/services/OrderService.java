package com.tikidev.orders_service.services;

import com.tikidev.orders_service.models.dtos.BaseResponse;
import com.tikidev.orders_service.models.dtos.OrderItemRequest;
import com.tikidev.orders_service.models.dtos.OrderRequest;
import com.tikidev.orders_service.models.entities.Order;
import com.tikidev.orders_service.models.entities.OrderItems;
import com.tikidev.orders_service.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.UUID;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private WebClient.Builder webClientBuilder;

    public void placeOrder (OrderRequest orderRequest) {

        //Check for inventory
        BaseResponse result = this.webClientBuilder.build()
                .post()
                .uri("http://localhost:8083/api/inventory/in-stock")
                .bodyValue(orderRequest.getOrderItems())
                .retrieve()
                .bodyToMono(BaseResponse.class)
                .block();

        if (result != null && !result.hasErrors()) {
            Order order = new Order();
            order.setOrderNumber(UUID.randomUUID().toString());
            order.setOrderItems(orderRequest.getOrderItems().stream()
                .map(orderItemRequest -> mapOrderItemRequestToOrderItem(orderItemRequest, order))
                .toList());
            this.orderRepository.save(order);
        }else{
            throw new IllegalArgumentException(result.toString());
        }
    }

    private OrderItems mapOrderItemRequestToOrderItem(OrderItemRequest orderItemRequest, Order order) {
        return OrderItems.builder()
                .id(orderItemRequest.getId())
                .sku(orderItemRequest.getSku())
                .price(orderItemRequest.getPrice())
                .quantity(orderItemRequest.getQuantity())
                .order(order)
                .build();
    }
}
