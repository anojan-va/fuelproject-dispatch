package com.lp.dispatch.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Dispatch {
	@Id
	@GeneratedValue
	@Column(name="dispatch_id")
	private int dispatchId;
	@Column(name="order_id")
	private int orderId;
	@Column(name="fuel_type")
	private String fuelType;
	@Column(name="dispatch_qty")
	private int dispatchQty;
	@Column(name="dispatch_date")
	private LocalDate dispatchDate=LocalDate.now();
	
}
