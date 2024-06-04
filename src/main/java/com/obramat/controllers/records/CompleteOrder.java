package com.obramat.controllers.records;

import com.obramat.persistence.entities.Order;
import com.obramat.persistence.entities.Product;

import java.util.List;

public record CompleteOrder(Order order, List<Product> products) {
}
