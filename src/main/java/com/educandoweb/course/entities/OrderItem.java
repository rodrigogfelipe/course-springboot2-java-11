package com.educandoweb.course.entities;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.educandoweb.course.entities.pk.OrderItemPk;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_order_item")
public class OrderItem implements Serializable {
	private static final long serialVersionUID = 1L;

	// Declarando a classe OrderItemPk
	@EmbeddedId
	private OrderItemPk id = new OrderItemPk();

	private Integer price;
	private Double quantity;

	// Declarando um cosntrutor padrao
	public OrderItem() {

	}

	public OrderItem(Order order, Product product, Integer price, Double quantity) {
		super();
		id.setOrder(order);
		id.setProduct(product);
		this.price = price;
		this.quantity = quantity;
	}

	// Declarando o metado Order para retorna ID
	@JsonIgnore
	public Order getOrder() {
		return id.getOrder();

	}

	public void setOrder(Order order) {
		id.setOrder(order);

	}

	// Declarando o metado Order para retorna ID
	public Product getProduct() {
		return id.getProduct();

	}

	public void setProduct(Product product) {
		id.setProduct(product);

	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Double getQuantity() {
		return quantity;
	}

	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderItem other = (OrderItem) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
