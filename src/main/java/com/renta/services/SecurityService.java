package com.renta.services;

import com.renta.exception.DAOException;
import com.renta.exception.LoginException;
import com.renta.model.User;

public interface SecurityService {
	User validate(String username, String password) throws LoginException, DAOException;
}
