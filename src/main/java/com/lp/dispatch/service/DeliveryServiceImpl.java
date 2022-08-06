package com.lp.dispatch.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lp.dispatch.model.Delivery;
import com.lp.dispatch.repository.DeliveryRepository;

@Service
public class DeliveryServiceImpl implements DeliveryService {

	@Autowired
	DeliveryRepository deliveryRepository;
	
	@Override
	public Delivery save(Delivery delivery) {
		
		return deliveryRepository.save(delivery);
	}

}
