package com.lp.dispatch.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Delivery {
	@Id
	@GeneratedValue
	@Column(name="delivery_id")
	private int deliveryId;
	@Column(name="order_id")
	private int orderId;
	@Column(name="fuel_type")
	private String fuelType;
	@Column(name="delivery_qty")
	private int deliveryQty;
	@Column(name="delivery_date")
	private LocalDate deliveryDate=LocalDate.now();
}
