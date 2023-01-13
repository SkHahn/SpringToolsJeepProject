package com.promineotech.jeep.service;

import com.promineotech.entity.Order;
import com.promineotech.entity.OrderRequest;

public interface JeepOrderService {

	Order createOrder(OrderRequest orderRequest);

}
