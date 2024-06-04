package com.obramat.persistence.repositories;

import com.obramat.persistence.entities.Order;
import com.obramat.persistence.entities.OrderStatus;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public interface OrderRepository extends PagingAndSortingRepository<Order, Long>, CrudRepository<Order, Long> {

    List<Order> findAllByCreationDateAndStatusAndPrice(
            @DateTimeFormat(pattern = "yyyy-MM-dd") Date creationDate,
            OrderStatus status,
            BigDecimal price
    );

}
