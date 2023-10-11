package com.example.AppleCustomer1.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.AppleCustomer1.Entity.AppleCustomer;

@Repository
public interface CustomerRepo extends JpaRepository<AppleCustomer, Integer> {

}
