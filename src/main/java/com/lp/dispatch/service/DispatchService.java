package com.lp.dispatch.service;

import com.lp.dispatch.model.Dispatch;

public interface DispatchService {

	public Dispatch save(Dispatch dispatch);
	
	public Dispatch findByOrderId(int orderId);
}
