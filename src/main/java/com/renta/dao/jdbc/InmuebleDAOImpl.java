package com.renta.dao.jdbc;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.renta.exception.DAOException;
import com.renta.exception.EmptyResultException;
import com.renta.exception.LoginException;

import com.renta.dao.InmuebleDAO;
import com.renta.maper.InmuebleMapper;
import com.renta.maper.UserMapper;
import com.renta.model.Inmueble;
import com.renta.model.User;

@Repository
public class InmuebleDAOImpl implements InmuebleDAO{
	
	private static final Logger logger = LoggerFactory.getLogger(InmuebleDAOImpl.class);

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public Inmueble findInmueble(int idinmueble) throws DAOException, EmptyResultException{
		
		String query = "SELECT idinmueble, direccion, coordenadas_dic, foto, descripcion, tipo_costo, costo, capacidad_max, tipo_inmueble, estado, usuarios_idusuarios, ranking_idranking"
				+ " FROM inmueble WHERE idinmueble = ?";
		Object[] params = new Object[] { idinmueble };
		
		try {

			Inmueble inm = (Inmueble) jdbcTemplate.queryForObject(query, params, new InmuebleMapper());
			//
			return inm;
			//return null;

		} catch (EmptyResultDataAccessException e) {
			throw new EmptyResultException();
		} catch (Exception e) {
			logger.info("Error: " + e.getMessage());
			throw new DAOException(e.getMessage());
		}
		
	}
	
	
	public void create(	String direccion, String coordenadas_dic, String foto, String descripcion, 
						String tipo_costo, String costo, String capacidad_max, String tipo_inmueble, 
						String estado, String usuarios_idusuario, String ranking_idranking) throws DAOException {

		String query = "INSERT INTO inmueble (direccion, coordenadas_dic, foto, descripcion, tipo_costo, costo, capacidad_max, tipo_inmueble, estado, usuarios_idusuario, ranking_idranking)  VALUES ( ?,?,?,?,?,? )";

		Object[] params = new Object[] {direccion, coordenadas_dic, foto, descripcion, tipo_costo, costo, capacidad_max, tipo_inmueble, estado, usuarios_idusuario, ranking_idranking };

		Inmueble inm = null;
		
		try {
			// create
			jdbcTemplate.update(query, params);
			// search
			inm = this.finInmuebleBytipo_costo(tipo_costo);

		} catch (EmptyResultException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			logger.info("Error: " + e.getMessage());
			throw new DAOException(e.getMessage());
		}
		

	}
	
	
	public void delete(String idinmueble) throws DAOException {

		String query = "DELETE FROM  inmueble WHERE idinmueble = ? ";

		Object[] params = new Object[] {idinmueble};

		try {
			jdbcTemplate.update(query, params);
		} catch (Exception e) {
			logger.info("Error: " + e.getMessage());
			throw new DAOException(e.getMessage());
		}
	}
	
	
	public void update(String direccion, String coordenadas_dic, String foto, String descripcion, 
			String tipo_costo, String costo, String capacidad_max, String tipo_inmueble, 
			String estado, String usuarios_idusuarios, String ranking_idranking) throws DAOException {

		String query = "UPDATE inmueble SET direccion = ?, coordenadas_dic =?, foto = ?, descripcion = ?, tipo_costo = ?, costo = ?, capacidad_max = ?, tipo_inmueble = ?, estado = ?, usuarios_idusuarios = ?, ranking_idranking = ? WHERE idinmueble = ?";

		Object[] params = new Object[] { direccion, coordenadas_dic, foto, descripcion, tipo_costo, costo, capacidad_max, tipo_inmueble, estado, usuarios_idusuarios, ranking_idranking};

		try {
			jdbcTemplate.update(query, params);
		} catch (Exception e) {
			logger.info("Error: " + e.getMessage());
			throw new DAOException(e.getMessage());
		}
	}
	
	
	
	public Inmueble finInmuebleBytipo_costo(String tipo_costo) throws DAOException, EmptyResultException {
		String query = "SELECT idinmueble, direccion, coordenadas_dic, foto, descripcion, tipo_costo, costo, capacidad_max, tipo_inmueble, estado, usuarios_idusuarios, ranking_idranking"
				+ " FROM inmueble WHERE tipo_costo = ? ";

		Object[] params = new Object[] { tipo_costo };

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
	
	
	
	public List<Inmueble> findAllInmuebles() throws DAOException, EmptyResultException {

		String query = "SELECT idinmueble, direccion, coordenadas_dic, foto, descripcion, tipo_costo, costo, capacidad_max, tipo_inmueble, estado, usuarios_idusuarios, ranking_idranking" +
						"FROM inmueble WHERE idinmueble = ?";

		try {

			List<Inmueble> inmuebles = jdbcTemplate.query(query, new InmuebleMapper());
			//
			return inmuebles;

		} catch (EmptyResultDataAccessException e) {
			throw new EmptyResultException();
		} catch (Exception e) {
			logger.info("Error: " + e.getMessage());
			throw new DAOException(e.getMessage());
		}
	}
	
	
	public List<Inmueble> findInmuebleBytipo_inmueble(String tipo_inmueble) throws DAOException, EmptyResultException {
		
		String query = "SELECT idinmueble, direccion, coordenadas_dic, foto, descripcion, tipo_costo, costo, capacidad_max, tipo_inmueble, estado, usuarios_idusuarios, ranking_idranking"
					+ " FROM inmueble WHERE upper(tipo_inmueble) like upper(?) ";

			Object[] params = new Object[] { "%" + tipo_inmueble + "%" };

			try {

				List<Inmueble> inm = jdbcTemplate.query(query, params, new InmuebleMapper());
				//
				return inm;

			} catch (EmptyResultDataAccessException e) {
				throw new EmptyResultException();
			} catch (Exception e) {
				logger.info("Error: " + e.getMessage());
				throw new DAOException(e.getMessage());
			}
		}
	
	
	
	
	public Inmueble validate(String idinmueble, String costo) throws LoginException, DAOException {
		
		logger.info("validate(): id: " + idinmueble + ", costo: " + costo);
	
		if ("".equals(idinmueble) && "".equals(costo)) {
			throw new LoginException("Username and password incorrect");
		}
	
		String query = "SELECT idinmueble, direccion, coordenadas_dic, foto, descripcion, tipo_costo, costo, capacidad_max, tipo_inmueble, estado, usuarios_idusuarios, ranking_idranking"
				+ " FROM inmueble WHERE username=? AND password=?";
	
		Object[] params = new Object[] { idinmueble, costo };
	
		try {
	
			Inmueble inm = (Inmueble) jdbcTemplate.queryForObject(query, params, new InmuebleMapper());
			//
			return inm;
	
		} catch (EmptyResultDataAccessException e) {
			logger.info("Username y/o password incorrecto");
			throw new LoginException();
		} catch (Exception e) {
			logger.info("Error: " + e.getMessage());
			throw new DAOException(e.getMessage());
		}
	}
}
