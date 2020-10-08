package org.lanqiao.security;


import org.lanqiao.entity.TConsumers;
import org.lanqiao.service.TConsumersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserDetailsServiceImpl implements UserDetailsService  {
	
	@Autowired
	TConsumersService tConsumersService;

 
	@Override
	public UserDetails loadUserByUsername(final String name) throws UsernameNotFoundException {
		TConsumers tConsumers = tConsumersService.queryById(name);
		if (name == null) {
			throw new UsernameNotFoundException(name + "该用户信息不存在");
		}else{
			List<GrantedAuthority> authList = new ArrayList<>();
			// 具体具有什么的权限
			authList.add(new SimpleGrantedAuthority(tConsumers.getRole_no().toString()));
			return new User(tConsumers.getName(),tConsumers.getPassword(),authList);

		}
	}
}