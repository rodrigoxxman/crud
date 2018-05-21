package com.renta.dao.jdbc;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.renta.dao.UserDAO;
import com.renta.dao.jdbc.UserDAOImpl;
import com.renta.exception.DAOException;
import com.renta.exception.EmptyResultException;
import com.renta.exception.LoginException;
import com.renta.maper.InmuebleMapper;
import com.renta.maper.UserMapper;
import com.renta.model.Inmueble;
import com.renta.model.User;

@Repository
public class UserDAOImpl implements UserDAO{
	
	private static final Logger logger = LoggerFactory.getLogger(UserDAOImpl.class);

	@Autowired
	private JdbcTemplate jdbcTemplate;


	public User findUser(int idusuario) throws DAOException, EmptyResultException {

		String query = "SELECT idusuario, username, password, nombre, apellido, correo, genero "
				+ " FROM usuario WHERE user_id = ?";

		Object[] params = new Object[] { idusuario };

		try {

			User usr = (User) jdbcTemplate.queryForObject(query, params, new UserMapper());
			//
			return usr;
			//return null;

		} catch (EmptyResultDataAccessException e) {
			throw new EmptyResultException();
		} catch (Exception e) {
			logger.info("Error: " + e.getMessage());
			throw new DAOException(e.getMessage());
		}
	}


	
	public void create(String username, String password, String nombre, String apellido, String correo, String genero) throws DAOException {

		String query = "INSERT INTO usuario (username, password, nombre, apellido, correo, genero)  VALUES ( ?,?,?,?,?,? )";

		Object[] params = new Object[] { username, password, nombre, apellido, correo, genero };

		User usr = null;
		
		try {
			// create
			jdbcTemplate.update(query, params);
			// search
			usr = this.finUserByUsername(username);

		} catch (EmptyResultException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			logger.info("Error: " + e.getMessage());
			throw new DAOException(e.getMessage());
		}
		

	}

	
	public void delete(String username) throws DAOException {

		String query = "DELETE FROM  usuario WHERE username = ? ";

		Object[] params = new Object[] { username};

		try {
			jdbcTemplate.update(query, params);
		} catch (Exception e) {
			logger.info("Error: " + e.getMessage());
			throw new DAOException(e.getMessage());
		}
	}

	
	public void update(String username, String password, String nombre, String apellido, String correo, String genero) throws DAOException {

		String query = "UPDATE usuario SET password = ?, nombre =?, apellido = ?, correo = ?, genero = ? WHERE username = ?";

		Object[] params = new Object[] {  password, nombre, apellido, correo, genero, username};

		try {
			jdbcTemplate.update(query, params);
		} catch (Exception e) {
			logger.info("Error: " + e.getMessage());
			throw new DAOException(e.getMessage());
		}
	}


	
	public User finUserByUsername(String Username) throws DAOException, EmptyResultException {
		String query = "SELECT idusuario, username, password, nombre, apellido, correo, genero "
				+ " FROM usuario WHERE username = ? ";

		Object[] params = new Object[] { Username };

		try {

			Inmueble inm = jdbcTemplate.queryForObject(query, params, new InmuebleMapper());
			//
			return inm;

		} catch (EmptyResultDataAccessException e) {
			throw new EmptyResultException();
		} catch (Exception e) {
			logger.info("Error: " + e.getMessage());
			throw new DAOException(e.getMessage());
		}
		
	}

	
	
	public List<User> findAllUsers() throws DAOException, EmptyResultException {

		String query = "SELECT idusuario, username, password, nombre, apellido, correo, genero FROM usuario ";

		try {

			List<User> users = jdbcTemplate.query(query, new UserMapper());
			//
			return users;

		} catch (EmptyResultDataAccessException e) {
			throw new EmptyResultException();
		} catch (Exception e) {
			logger.info("Error: " + e.getMessage());
			throw new DAOException(e.getMessage());
		}
	}

public List<User> findUserByNombre(String nombre) throws DAOException, EmptyResultException {
		
	String query = "SELECT idusuario, username, password, nombre, apellido, correo, genero "
				+ " FROM usuario WHERE upper(nombre) like upper(?) ";

		Object[] params = new Object[] { "%" + nombre + "%" };

		try {

			List<User> users = jdbcTemplate.query(query, params, new UserMapper());
			//
			return users;

		} catch (EmptyResultDataAccessException e) {
			throw new EmptyResultException();
		} catch (Exception e) {
			logger.info("Error: " + e.getMessage());
			throw new DAOException(e.getMessage());
		}
	}


	public User validate(String username, String password) throws LoginException, DAOException {
	
		logger.info("validate(): login: " + username + ", clave: " + password);
	
		if ("".equals(username) && "".equals(password)) {
			throw new LoginException("Username and password incorrect");
		}
	
		String query = "SELECT idusuario, username, password, nombre, apellido, correo, genero "
				+ " FROM inmueble WHERE username=? AND password=?";
	
		Object[] params = new Object[] { username, password };
	
		try {
	
			User usr = (User) jdbcTemplate.queryForObject(query, params, new UserMapper());
			//
			return usr;
	
		} catch (EmptyResultDataAccessException e) {
			logger.info("Username y/o password incorrecto");
			throw new LoginException();
		} catch (Exception e) {
			logger.info("Error: " + e.getMessage());
			throw new DAOException(e.getMessage());
		}
	}



	


	


}
