package com.lp.dispatch.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lp.dispatch.kafka.DispatchProducer;
import com.lp.dispatch.model.Dispatch;
import com.lp.dispatch.service.DispatchService;
import com.lp.order.model.Order;
import com.lp.order.model.OrderEvent;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping(value="/dispatchservices")
public class DispatchController {
	
	@Autowired
	DispatchService dispatchService;
	
	@Autowired
	DispatchProducer dispatchProducer;
	
	public DispatchController(DispatchProducer dispatchProducer) {
		super();
		this.dispatchProducer = dispatchProducer;
	}

	@RequestMapping(value = "/dispatches",method = RequestMethod.POST)
	public Dispatch saveDispatch(@RequestBody Dispatch dispatch) {
		
		Dispatch dispatchResponse = new Dispatch();
		dispatchResponse = dispatchService.save(dispatch);
		
		
		Order order_response= new Order();
		
		order_response.setOrderId(dispatchResponse.getOrderId());
		order_response.setOrderStatus("Dispatched");
		order_response.setStatusDate(dispatchResponse.getDispatchDate());
		order_response.setFuelType(dispatchResponse.getFuelType());
		order_response.setQuantity(dispatchResponse.getDispatchQty());
		
		OrderEvent orderEvent = new OrderEvent();
		orderEvent.setMessage("Order Dispatched");
		orderEvent.setStatus("sucess");
		orderEvent.setOrder(order_response);
		dispatchProducer.sendMessage(orderEvent);
		System.out.println(orderEvent.getOrder().getOrderStatus()+":System print");
				
		return dispatchResponse;
	}
	
	@RequestMapping(value="/dispatch",method =RequestMethod.GET)
	public Dispatch getbyOrderId(@RequestParam int orderId) {
		return dispatchService.findByOrderId(orderId);
		
	}
}
