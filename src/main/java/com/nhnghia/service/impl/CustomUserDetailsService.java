package com.nhnghia.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.nhnghia.constant.SystemConstant;
import com.nhnghia.dto.MyUser;
import com.nhnghia.entity.RoleEntity;
import com.nhnghia.entity.UserEntity;
import com.nhnghia.repository.IUserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService{
	
	@Autowired
	private IUserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserEntity userEntity = userRepository.findOneByUserNameAndStatus(username, SystemConstant.ACTIVE_STATUS);
		if (userEntity == null) {
			throw new UsernameNotFoundException("User not found!");
		}
		List<GrantedAuthority> authorities = new ArrayList<>();
		for (RoleEntity role : userEntity.getRoleList()) {
			authorities.add(new SimpleGrantedAuthority(role.getCode()));
		}
		// put thông tin vào security và duy trì thông tin đó khi user đăng nhập vào hệ thống
//		User user = new User(userEntiry.getUserName(), userEntiry.getPassword(), true, true, true, true, authorities);
		
		MyUser myUser = new MyUser(userEntity.getUserName(), userEntity.getPassword(), true, true, true, true, authorities);
		myUser.setFullName(userEntity.getFullName());
		
		return myUser;
	}

}
