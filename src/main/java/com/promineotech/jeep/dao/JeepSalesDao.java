package com.promineotech.jeep.dao;

import java.util.List;

import com.promineotech.entity.Jeep;

public interface JeepSalesDao {

	List<Jeep> fetchJeeps(String model, String trim);

}
