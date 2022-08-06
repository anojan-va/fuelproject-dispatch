package com.lp.dispatch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lp.dispatch.model.Delivery;

@Repository
public interface DeliveryRepository extends JpaRepository<Delivery, Integer>{
	
}
