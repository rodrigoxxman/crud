package com.renta.dao;

import java.util.List;

import com.renta.exception.DAOException;
import com.renta.exception.EmptyResultException;
import com.renta.exception.LoginException;
import com.renta.model.User;

public interface UserDAO {
	User findUser(int idusuario) throws DAOException, EmptyResultException;

	void create(String username, String password, String nombre, String apellido, String correo, String genero) throws DAOException;

	void delete(String username) throws DAOException;

	void update(String username, String password, String nombre, String apellido, String correo, String genero) throws DAOException;

	User finUserByUsername(String Username) throws DAOException, EmptyResultException;

	List<User> findAllUsers() throws DAOException, EmptyResultException;

	List<User> findUserByNombre(String nombre) throws DAOException, EmptyResultException;

	User validate(String idUser, String clave) throws LoginException, DAOException;

	}
