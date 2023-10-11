package com.example.AppleCustomer1.Service;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.project.appleStore1.entityAppleStore.AppleStoreSeller;

@Service
public class CustomerService {

	private final RestTemplate restTemplate;

	public CustomerService() {
		this.restTemplate = new RestTemplate();
	}

	public List<AppleStoreSeller> retriveData() {
		String url = "http://localhost:8095/api/product/visitiplanet";
		ResponseEntity<AppleStoreSeller[]> response = restTemplate.getForEntity(url, AppleStoreSeller[].class);
		AppleStoreSeller[] apple = response.getBody();
		return Arrays.asList(apple);
	}
}
