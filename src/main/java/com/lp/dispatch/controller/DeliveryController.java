package com.lp.dispatch.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lp.dispatch.kafka.DeliveryProducer;
import com.lp.dispatch.model.Delivery;
import com.lp.dispatch.model.Dispatch;
import com.lp.dispatch.service.DeliveryService;
import com.lp.order.model.Order;
import com.lp.order.model.OrderEvent;


@RestController
@RequestMapping(value="/deliveryservices")
public class DeliveryController {
	
	@Autowired
	DeliveryService deliveryService;
	
	@Autowired
	DeliveryProducer deliveryProducer;
	
	public DeliveryController(DeliveryProducer deliveryProducer){
		super();
		this.deliveryProducer = deliveryProducer;
	}

	@RequestMapping(value = "/deliveries",method = RequestMethod.POST)
	public Delivery saveDelivery(@RequestBody Delivery delivery) {
				
		Delivery deliveryResponse = new Delivery();
		deliveryResponse = deliveryService.save(delivery);
		
		
		Order order_response= new Order();
		
		order_response.setOrderId(deliveryResponse.getOrderId());
		order_response.setOrderStatus("Delivered");
		order_response.setStatusDate(deliveryResponse.getDeliveryDate());
		
		OrderEvent orderEvent = new OrderEvent();
		orderEvent.setMessage("Order Delivered");
		orderEvent.setStatus("sucess");
		orderEvent.setOrder(order_response);
		deliveryProducer.sendMessage(orderEvent);
				
		return deliveryResponse;
	}

}
