package com.renta.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.renta.dao.InmuebleDAO;
import com.renta.dao.UserDAO;
import com.renta.exception.DAOException;
import com.renta.exception.EmptyResultException;
import com.renta.model.Inmueble;
import com.renta.model.User;

@Service
public class InmuebleServiceImpl implements InmuebleService {
	
	@Autowired
	private InmuebleDAO inmuebleDAO;
	
	
	public Inmueble find(int idinmueble) throws DAOException, EmptyResultException {
		Inmueble inm = inmuebleDAO.findInmueble(idinmueble);
		return inm;
	}
	
	
	public List<Inmueble> findAll() throws DAOException, EmptyResultException {
		List<Inmueble> inm = inmuebleDAO.findAllInmuebles();

		return inm;
	}


	public void update(String direccion, String coordenadas_dic, String foto, String descripcion, 
			String tipo_costo, String costo, String capacidad_max, String tipo_inmueble, 
			String estado, String usuarios_idusuario, String ranking_idranking)
			throws DAOException {
	inmuebleDAO.update( direccion, coordenadas_dic, foto, descripcion, tipo_costo, costo, capacidad_max, tipo_inmueble,
			estado, usuarios_idusuario, ranking_idranking);
		
	}


	public void create(String direccion, String coordenadas_dic, String foto, String descripcion, 
			String tipo_costo, String costo, String capacidad_max, String tipo_inmueble, 
			String estado, String usuarios_idusuario, String ranking_idranking)
			throws DAOException {
	inmuebleDAO.create(direccion, coordenadas_dic, foto, descripcion, tipo_costo, costo, capacidad_max, tipo_inmueble, estado, usuarios_idusuario, ranking_idranking);
		
	}

}
