package com.nagarro.hrmanager.dao;

import org.springframework.data.repository.CrudRepository;

import com.nagarro.hrmanager.entity.Login;

public interface UserLoginRepository extends CrudRepository<Login, Integer> {

}
