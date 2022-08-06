package com.lp.dispatch.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.lp.dispatch.model.Delivery;
import com.lp.dispatch.service.DeliveryService;


@RestController
@RequestMapping(value="/deliveryservices")
public class DeliveryController {
	
	@Autowired
	DeliveryService deliveryService;

	@RequestMapping(value = "/deliveries",method = RequestMethod.POST)
	public Delivery saveDelivery(@RequestBody Delivery delivery) {
		
		return deliveryService.save(delivery);
	}

}
