package br.com.portifolioLira.curso.entities.pk;

import br.com.portifolioLira.curso.entities.Order;
import br.com.portifolioLira.curso.entities.Product;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

@Embeddable //classe auxiliar de chave composta, se representa com Embeddable.
public class OrderItemPK implements Serializable {

    @Serial
    private static final long serialVersionUID =1L;

    @ManyToOne
    @JoinColumn (name = "order_id")
    private Order order;

    @ManyToOne
    @JoinColumn (name = "product_id")
    private Product product;

    //Essa classe não tem o construtor

    public Order getOrder() {
        return order;
    }
    public void setOrder(Order order) {
        this.order = order;
    }
    public Product getProduct() {
        return product;
    }
    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrderItemPK that)) return false;
        return Objects.equals(order, that.order) && Objects.equals(product, that.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(order, product);
    }
}
