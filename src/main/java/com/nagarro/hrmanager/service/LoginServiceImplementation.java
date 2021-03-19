package com.nagarro.hrmanager.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.hrmanager.dao.UserLoginRepository;
import com.nagarro.hrmanager.entity.Login;


@Service
public class LoginServiceImplementation implements LoginService  {

	@Autowired
	private UserLoginRepository loginRepository;
	
	@Override
	public boolean checkLogin(int userId, String userPassword) {
		Optional<Login> find =loginRepository.findById(userId);
		Login login = null;
		
		if(find.isPresent()) {

			login = find.get();
			if(login.getPassword().equals(userPassword)) {
				return true;
				
			}
			
		}
		return false;
		
		
	}

}
