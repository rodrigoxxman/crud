package com.renta.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.renta.dao.UserDAO;
import com.renta.exception.DAOException;
import com.renta.exception.LoginException;
import com.renta.model.User;


@Service
public class SecurityServiceImpl implements SecurityService{

	@Autowired
	private UserDAO userDAO;
	
	public User validate(String username, String password) throws LoginException, DAOException {
		User usr = userDAO.validate(username, password);

		return usr;
	}

}
