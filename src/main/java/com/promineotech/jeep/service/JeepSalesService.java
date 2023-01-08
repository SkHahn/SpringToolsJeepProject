package com.promineotech.jeep.service;

import java.util.List;

import com.promineotech.entity.Jeep;
import com.promineotech.entity.JeepModel;

public interface JeepSalesService {

	/**
	 * 
	 * @param model
	 * @param trim
	 * @return
	 */
	
	List<Jeep> fetchJeeps(String model, String trim);

}
