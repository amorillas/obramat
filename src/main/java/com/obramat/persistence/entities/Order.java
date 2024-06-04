package com.obramat.persistence.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name="`order`")
public class Order {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    @Temporal(TemporalType.DATE)
    private Date creationDate;
    private BigDecimal price;
    private BigDecimal priceWithIVA;
    private OrderStatus status;

    @OneToMany(mappedBy = "order")
    Set<Product> products;

    public Order() {
    }

    public Order(Long id, Date creationDate, BigDecimal price, OrderStatus status) {
        this.id = id;
        this.creationDate = creationDate;
        setPrice(price);
        this.status = status;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", creationDate=" + creationDate +
                ", productsCount=" + getProductsCount() +
                ", price=" + price +
                ", priceWithIVA=" + priceWithIVA +
                ", status=" + status +
                '}';
    }

    public Long getId() {
        return id;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public int getProductsCount() {
        return products.size();
    }

    public BigDecimal getPrice() {
        return price;
    }

    public BigDecimal getPriceWithIVA() {
        return priceWithIVA;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
        this.priceWithIVA = price.multiply(BigDecimal.valueOf(1.21f));
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    public Set<Product> getProducts() {
        return products;
    }
}
