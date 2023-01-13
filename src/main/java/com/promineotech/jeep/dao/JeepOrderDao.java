package com.promineotech.jeep.dao;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import com.promineotech.entity.Color;
import com.promineotech.entity.Customer;
import com.promineotech.entity.Engine;
import com.promineotech.entity.Jeep;
import com.promineotech.entity.JeepModel;
import com.promineotech.entity.Option;
import com.promineotech.entity.Order;
import com.promineotech.entity.OrderRequest;
import com.promineotech.entity.Tire;

public interface JeepOrderDao {

	Order createOrder(OrderRequest orderRequest);

	  List<Option> fetchOptions(List<String> optionIds);
	  Optional<Customer> fetchCustomer(String customerId);
	  Optional<Jeep> fetchModel(JeepModel model, String trim, int doors);
	  Optional<Color> fetchColor(String colorId);
	  Optional<Engine> fetchEngine(String engineId);
	  Optional<Tire> fetchTire(String tireId);

	static Order saveOrder(Customer customer, Jeep jeep, Color color, Engine engine, Tire tire, BigDecimal price,
			List<Option> options) {
		return null;
	}
	  
}
