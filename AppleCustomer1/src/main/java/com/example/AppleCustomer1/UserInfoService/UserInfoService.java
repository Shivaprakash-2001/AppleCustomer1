package com.example.AppleCustomer1.UserInfoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.AppleCustomer1.Entity.UserInfo;
import com.example.AppleCustomer1.Repository.UserInforepo;

@Service
public class UserInfoService {

	@Autowired
	private UserInforepo userinfo;

	@Autowired
	private PasswordEncoder encoder;

	public UserInfo saveUser(UserInfo userInfo) {
		userInfo.setPassword(encoder.encode(userInfo.getPassword()));
		return userinfo.save(userInfo);
	}
}
