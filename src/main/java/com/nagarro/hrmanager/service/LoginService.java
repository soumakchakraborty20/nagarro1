package com.nagarro.hrmanager.service;

import org.springframework.stereotype.Service;

@Service
public interface LoginService {

	public boolean checkLogin(int userId, String userPassword);

}
