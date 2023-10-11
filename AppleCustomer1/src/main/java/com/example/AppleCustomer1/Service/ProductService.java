package com.example.AppleCustomer1.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.project.appleStore1.entityAppleStore.AppleStoreSeller;

@Service
public class ProductService {

	@Autowired
	private RestTemplate restTemplate;

	private final String STORE_BASE_URL = "http://localhost:8095/api/product/";

	public AppleStoreSeller getProductDetailsByModelNumber(int modelNumber) {
		String url = STORE_BASE_URL + "/findbyModel/" + modelNumber;
		return restTemplate.getForObject(url, AppleStoreSeller.class);
	}
}
