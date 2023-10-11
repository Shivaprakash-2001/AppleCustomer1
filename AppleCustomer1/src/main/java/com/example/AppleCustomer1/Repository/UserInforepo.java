package com.example.AppleCustomer1.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.AppleCustomer1.Entity.UserInfo;

@Repository
public interface UserInforepo extends JpaRepository<UserInfo, Integer> {

	public Optional<UserInfo> findByUsername(String username);

}
