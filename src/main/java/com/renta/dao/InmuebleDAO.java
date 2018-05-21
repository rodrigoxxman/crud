package com.renta.dao;

import java.util.List;

import com.renta.exception.DAOException;
import com.renta.exception.EmptyResultException;
import com.renta.exception.LoginException;
import com.renta.model.Inmueble;

public interface InmuebleDAO {
	
	Inmueble findInmueble(int idinmueble) throws DAOException, EmptyResultException;

	void create(String direccion, String coordenadas_dic, String foto, String descripcion, 
				String tipo_costo, String costo, String capacidad_max, String tipo_inmueble, 
				String estado, String usuarios_idusuario, String ranking_idranking) throws DAOException;

	void delete(String idinmueble) throws DAOException;

	void update(String direccion, String coordenadas_dic, String foto, String descripcion, 
				String tipo_costo, String costo, String capacidad_max, String tipo_inmueble, 
				String estado, String usuarios_idusuario, String ranking_idranking) throws DAOException;

	Inmueble finInmuebleBytipo_costo(String tipo_costo) throws DAOException, EmptyResultException;

	List<Inmueble> findAllInmuebles() throws DAOException, EmptyResultException;

	List<Inmueble> findInmuebleBytipo_inmueble(String tipo_inmueble) throws DAOException, EmptyResultException;

	//puede ser pero no
	Inmueble validate(String idinmueble, String costo) throws LoginException, DAOException;

}
