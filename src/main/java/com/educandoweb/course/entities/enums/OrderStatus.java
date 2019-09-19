package com.educandoweb.course.entities.enums;

public enum OrderStatus {
	WAITING_PAYMENT(1), 
	PAID(2), 
	SHIPPED(3), 
	DELIVERED(4), 
	CANCELED(5);

	private int code;
	// Declarando um construtor

	private OrderStatus(int code) {
		this.code = code;
	}

	public int getCode() {
		return code;
	}

	// declarando metado OrderStatus
	public static OrderStatus valueOf(int code) {
		for (OrderStatus value : OrderStatus.values()) {
			if (value.getCode() == code) { // Code for igual ao code retorna value, caso não seja invalido lançara uma
											// exception
				return value;

			}

		}
		throw new IllegalArgumentException("Invalid OrdersStatus code ");

	}

}
