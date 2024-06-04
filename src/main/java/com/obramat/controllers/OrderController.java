package com.obramat.controllers;

import com.obramat.controllers.records.CompleteOrder;
import com.obramat.persistence.entities.Order;
import com.obramat.persistence.repositories.OrderRepository;
import com.obramat.persistence.repositories.ProductRepository;
import com.obramat.services.OrderService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping("orders/create-complete")
    public Order createCompleteOrder(@RequestBody CompleteOrder completeOrder) {
        return this.orderService.saveCompleteOrder(completeOrder);
    }

    @GetMapping("orders/{pk}/complete")
    public ResponseEntity<Order> getCompleteOrder(@PathVariable Long pk) {
        Optional<Order> order = this.orderService.getCompleteOrder(pk);
        return order.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
    }

}
