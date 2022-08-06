package com.lp.dispatch.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lp.dispatch.model.Dispatch;
import com.lp.dispatch.service.DispatchService;

@RestController
@RequestMapping(value="/dispatchservices")
public class DispatchController {
	
	@Autowired
	DispatchService dispatchService;

	@RequestMapping(value = "/dispatches",method = RequestMethod.POST)
	public Dispatch saveDispatch(@RequestBody Dispatch dispatch) {
		
		return dispatchService.save(dispatch);
	}
}
