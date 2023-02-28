package com.ty.fabrico.fabrico_springboot.jwt;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ty.fabrico.fabrico_springboot.dao.WeaverDao;
import com.ty.fabrico.fabrico_springboot.dao.WeaverEmailDao;
import com.ty.fabrico.fabrico_springboot.dto.Weaver;
import com.ty.fabrico.fabrico_springboot.dto.WeaverEmail;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private WeaverDao dao;

	@Autowired
	private WeaverEmailDao emailDao;

	@Override
	public UserDetails loadUserByUsername(String wemail) throws UsernameNotFoundException {
WeaverEmail email=emailDao.getWeaverByEmail(wemail);
		if(wemail.equals("manoj@mail.com")) {
			return new User("manoj@mail.com","123",new ArrayList<>());
		}
		else if(email!=null) {
			return new User(email.getWemail(),email.getWeaver().getPassword(),new ArrayList<>());
		}
		else {
			throw new UsernameNotFoundException("User Not Found");
		}
	}

}
