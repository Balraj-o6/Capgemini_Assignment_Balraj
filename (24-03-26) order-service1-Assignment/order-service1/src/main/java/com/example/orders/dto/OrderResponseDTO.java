package com.example.orders.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderResponseDTO {

	private Long id;
	private String customerName;
	private String email;
	private String productName;
	private int quantity;
	private double pricePerUnit;
	private double totalAmount;
	
	
	
	public OrderResponseDTO(Long id, String customerName, String email, String productName, int quantity,
			double pricePerUnit, double totalAmount) {
		super();
		this.id = id;
		this.customerName = customerName;
		this.email = email;
		this.productName = productName;
		this.quantity = quantity;
		this.pricePerUnit = pricePerUnit;
		this.totalAmount = totalAmount;
	}

	public Long getOrderId() {
		return id;
	}

	public void setOrderId(Long orderId) {
		this.id = orderId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPricePerUnit() {
		return pricePerUnit;
	}

	public void setPricePerUnit(double pricePerUnit) {
		this.pricePerUnit = pricePerUnit;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

}
