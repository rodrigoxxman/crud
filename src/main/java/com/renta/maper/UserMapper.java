package com.renta.maper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.renta.model.User;

public class UserMapper implements RowMapper<User>{
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		User usr = new User();
		usr.setIdusuario(rs.getInt("idusuario"));
		usr.setUsername(rs.getString("username"));
		usr.setPassword(rs.getString("password"));
		usr.setNombre(rs.getString("nombre"));
		usr.setApellido(rs.getString("apellido"));
		usr.setCorreo(rs.getString("correo"));
		usr.setGenero(rs.getString("genero"));
		return usr;
	}
	

}
