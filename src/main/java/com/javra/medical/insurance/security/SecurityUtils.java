package com.javra.medical.insurance.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.javra.medical.insurance.model.User;
import com.javra.medical.insurance.service.UserService;

@Service
public class SecurityUtils {
	@Autowired
	private UserService userservice;

	public static String getCurrentLogin() {
		SecurityContext securityContext = SecurityContextHolder.getContext();
		Authentication authentication = securityContext.getAuthentication();
		UserDetails springSecurityUser = null;
		String userName = null;

		if (authentication != null) {
			if (authentication.getPrincipal() instanceof UserDetails) {
				springSecurityUser = (UserDetails) authentication.getPrincipal();

				userName = springSecurityUser.getUsername();
			} else if (authentication.getPrincipal() instanceof String) {
				userName = (String) authentication.getPrincipal();
			}
		}

		return userName;
	}

	public User curentLoginUserObject() {

		SecurityContext securityContext = SecurityContextHolder.getContext();
		Authentication authentication = securityContext.getAuthentication();
		UserDetails springSecurityUser = null;
		String userName = null;

		if (authentication != null) {
			if (authentication.getPrincipal() instanceof UserDetails) {
				springSecurityUser = (UserDetails) authentication.getPrincipal();

				userName = springSecurityUser.getUsername();
			} else if (authentication.getPrincipal() instanceof String) {
				userName = (String) authentication.getPrincipal();
			}
		}

		return userservice.findByUserName(userName);
	}

}
