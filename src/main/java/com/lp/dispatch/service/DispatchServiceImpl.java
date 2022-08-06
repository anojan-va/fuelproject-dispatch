package com.lp.dispatch.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lp.dispatch.model.Dispatch;
import com.lp.dispatch.repository.DispatchRepository;

@Service
public class DispatchServiceImpl implements DispatchService{
	
	@Autowired
	DispatchRepository dispatchRepository;

	@Override
	public Dispatch save(Dispatch dispatch) {
		return dispatchRepository.save(dispatch);
	}
	
}
