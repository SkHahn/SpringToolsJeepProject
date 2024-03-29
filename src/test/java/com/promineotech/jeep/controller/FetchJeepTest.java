package com.promineotech.jeep.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpMethod;
import com.promineotech.entity.Jeep; 
import com.promineotech.entity.JeepModel;
import com.promineotech.jeep.controller.support.FetchJeepTestSupport;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
@Sql(scripts = {"classpath:/jeep-sales/src/test/flyway/migrations/V1.0__Jeep_Schema.sql,", "classpath:/jeep-sales/src/test/flyway/migrations/V1.1__Jeep_Data.sql,"},
				config = @SqlConfig(encoding = "utf-8"))
class FetchJeepTest extends FetchJeepTestSupport {

	/**
	 * 1
	 */
	@Test
	void testThatJeepsAreReturnedWhenAValidModelAndTrimAreSupplied() {
		//Given: a valid model, trim and URI
		JeepModel model = JeepModel.WRANGLER;
		String trim = "Sport";
		String uri = String.format("%s?model=%s&trim=%s", getBaseUriForJeeps(), model, trim);
		
		//When: a connection is made to the URI
		ResponseEntity<List<Jeep>> response =
				getRestTemplate().exchange(uri, HttpMethod.GET, null, new ParameterizedTypeReference<>() {});
		
		//Then: a success (OK - 200) status code is returned
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		
		//And: the actual list is the same as the expected list
		List<Jeep> actual = response.getBody();
		List<Jeep> expected = buildExpected();
		
		actual.forEach(Jeep -> Jeep.setModelPK(null));
		
		assertThat(actual).isEqualTo(expected);
	}

}