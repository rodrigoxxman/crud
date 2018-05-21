package com.renta.services;

import java.util.List;

import com.renta.exception.DAOException;
import com.renta.exception.EmptyResultException;
import com.renta.model.Inmueble;

public interface InmuebleService {

	Inmueble find(int idinmueble) throws DAOException, EmptyResultException;
	List<Inmueble> findAll() throws DAOException, EmptyResultException;
	
	void update(String direccion, String coordenadas_dic, String foto, String descripcion, String tipo_costo, String costo, 
				String capacidad_max, String tipo_inmueble, String estado, String usuarios_idusuario, String ranking_idranking)
	throws DAOException;
	
	void create(String direccion, String coordenadas_dic, String foto, String descripcion, String tipo_costo, String costo, 
				String capacidad_max, String tipo_inmueble, String estado, String usuarios_idusuario, String ranking_idrankin)
	throws DAOException;
	Inmueble removePerson(int idinmueble) throws DAOException;
	void delete(int idinmueble);
}
