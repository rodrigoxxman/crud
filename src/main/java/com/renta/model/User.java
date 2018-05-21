package com.renta.model;

public class User {
	
	String username;
	String password;
	int idusuario;
	String nombre;
	String apellido;
	String correo;
	String genero;
	
	
	public User(String username, String password, int idusuario, String nombre, String apellido, String correo,
			String genero) {
		super();
		this.username = username;
		this.password = password;
		this.idusuario = idusuario;
		this.nombre = nombre;
		this.apellido = apellido;
		this.correo = correo;
		this.genero = genero;
	}
	
	
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}


	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getIdusuario() {
		return idusuario;
	}
	public void setIdusuario(int idusuario) {
		this.idusuario = idusuario;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}



	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", idusuario=" + idusuario + ", nombre="
				+ nombre + ", apellido=" + apellido + ", correo=" + correo + ", genero=" + genero + "]";
	}
	
	}
