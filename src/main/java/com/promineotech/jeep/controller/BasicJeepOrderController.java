package com.promineotech.jeep.controller;

import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.web.bind.annotation.RestController;

import com.promineotech.entity.Order;
import com.promineotech.entity.OrderRequest;
import com.promineotech.jeep.service.JeepOrderService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class BasicJeepOrderController implements JeepOrderController {

	@AutoConfigureOrder
	private JeepOrderService jeepOrderService; 
	
	@Override
	public Order createOrder(OrderRequest orderRequest) {
		log.debug("order={}", orderRequest);
		return jeepOrderService.createOrder(orderRequest);
	}

}
