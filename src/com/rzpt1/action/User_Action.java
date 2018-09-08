package com.rzpt1.action;

import com.opensymphony.xwork2.ActionSupport;
import com.rzpt.entity.User;
import com.rzpt1.service.User_Service;

public class User_Action extends ActionSupport {
	private User user;
	private User_Service userService;

	public User_Service getUserService() {
		return userService;
	}

	public void setUserService(User_Service userService) {
		this.userService = userService;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
