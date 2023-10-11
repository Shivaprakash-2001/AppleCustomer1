package com.example.AppleCustomer1.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.AppleCustomer1.Entity.AppleCustomer;
import com.example.AppleCustomer1.Repository.CustomerRepo;
import com.example.AppleCustomer1.Service.CustomerService;
import com.example.AppleCustomer1.Service.ProductService;
import com.example.AppleCustomer1.UserInfoService.JwtService;
import com.example.AppleCustomer1.pojo.AuthRequest;
import com.project.appleStore1.entityAppleStore.AppleStoreSeller;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

	@Autowired
	CustomerRepo customerRepo;

	@Autowired
	CustomerService customerservice;

	@Autowired
	private ProductService productService;

	@GetMapping("/apple")
	public List<AppleStoreSeller> getAllApple() {
		List<AppleStoreSeller> seller = customerservice.retriveData();
		return seller;
	}

	@GetMapping("/product/{modelNumber}")
	public AppleStoreSeller getProductDetails(@PathVariable int modelNumber) {
		return productService.getProductDetailsByModelNumber(modelNumber);
	}

	@GetMapping("/all")
	public List<AppleCustomer> getAllCustomer() {
		return this.customerRepo.findAll();
	}

	@PostMapping("/create")
	public AppleCustomer createCustomer(@RequestBody AppleCustomer appleCustomer) {
		return this.customerRepo.save(appleCustomer);
	}

	@GetMapping("/find/{id}")
	public Optional<AppleCustomer> findCustomerById(@PathVariable int id) {
		return customerRepo.findById(id);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteCustomerById(@PathVariable int id) {
		Optional<AppleCustomer> customerOptional = customerRepo.findById(id);
		if (customerOptional.isPresent()) {
			customerRepo.deleteById(id);
			return "Customer with ID " + id + " deleted successfully.";
		} else {
			return "Customer with ID " + id + " not found.";
		}
	}

	@Autowired
	private JwtService jwtService;

	@Autowired
	private AuthenticationManager authenticationManager;

	@PostMapping("/auth")
	public String generateToken(@RequestBody AuthRequest authRequest) {
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
		if (authentication.isAuthenticated()) {
			return jwtService.generateToken(authRequest.getUsername());
		} else {
			throw new UsernameNotFoundException("Invalid User");
		}

	}

}
