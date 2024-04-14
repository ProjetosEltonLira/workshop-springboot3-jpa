package br.com.portifolioLira.curso.entities;

import br.com.portifolioLira.curso.entities.pk.OrderItemPK;
import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;


@Entity // Usado para informar que essa classe é uma entidade para JPA.
@Table(name = "tb_order_item")
public class OrderItem implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @EmbeddedId //ID embedados (Ambos chaves primárias)
    private OrderItemPK orderItemPK;
    private Integer quantity;
    private Double price;

    public OrderItem(){}
    public OrderItem(Order order, Product product, Integer quantity, Double price) {
        orderItemPK.setOrder(order);
        orderItemPK.setProduct(product);
        this.quantity = quantity;
        this.price = price;
    }

    public Order getOrder(){
        return orderItemPK.getOrder();
    }
    public void SetOrder(Order order){
        orderItemPK.setOrder(order);
    }

    public Product getProduct(){
        return orderItemPK.getProduct();
    }
    public void SetProduct(Product product){
        orderItemPK.setProduct(product);
    }


    public Integer getQuantity() {
        return quantity;
    }
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrderItem orderItem)) return false;
        return Objects.equals(orderItemPK, orderItem.orderItemPK);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderItemPK);
    }
}
