package com.example.AppleCustomer1.UserInfoService;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.example.AppleCustomer1.Dto.UserInfoUserDeatil;
import com.example.AppleCustomer1.Entity.UserInfo;
import com.example.AppleCustomer1.Repository.UserInforepo;

@Component
public class UserDetasilService implements UserDetailsService {

	@Autowired
	private UserInforepo userInfoRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<UserInfo> userInfo = userInfoRepo.findByUsername(username);
		return userInfo.map(UserInfoUserDeatil::new).orElseThrow();
	}

}