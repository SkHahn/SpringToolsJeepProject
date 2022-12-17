package com.promineotech.jeep.service;

import java.util.List;

import com.promineotech.entity.Jeep;

public interface JeepSalesService {

	/**
	 * 
	 * @param model
	 * @param trim
	 * @return
	 */
	
	List<Jeep> fetchJeeps(String model, String trim);

}
