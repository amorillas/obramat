package com.obramat.services;

import com.obramat.controllers.records.CompleteOrder;
import com.obramat.persistence.entities.Order;
import com.obramat.persistence.entities.Product;
import com.obramat.persistence.repositories.OrderRepository;
import com.obramat.persistence.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;
    @Autowired
    ProductRepository productRepository;

    public Order saveCompleteOrder(CompleteOrder completeOrder) {
        Order order = completeOrder.order();
        List<Product> products = completeOrder.products();
        Set<Product> productsSet = new HashSet<>(products);
        order.setProducts(productsSet);
        Order savedOrder = this.orderRepository.save(order);
        products.forEach(product -> product.setOrder(savedOrder));
        this.productRepository.saveAll(products);

        return savedOrder;
    }

    public Optional<Order> getCompleteOrder(Long pk) {
        return this.orderRepository.findById(pk);
    }
}
