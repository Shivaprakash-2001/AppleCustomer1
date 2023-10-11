package com.example.AppleCustomer1.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.AppleCustomer1.Entity.UserInfo;
import com.example.AppleCustomer1.Repository.UserInforepo;
import com.example.AppleCustomer1.UserInfoService.UserInfoService;

@RestController
@RequestMapping("/api/user")
public class UserInfoController {

	@Autowired
	private UserInforepo userinfo;

	@Autowired
	private UserInfoService userInfoService;

	@PostMapping("/save")
	public String saveUser(@RequestBody UserInfo userInfo) {
		userInfoService.saveUser(userInfo);
		return "user saved";
	}

}
