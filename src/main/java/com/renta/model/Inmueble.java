package com.renta.model;

public class Inmueble {

	int idinmueble;
	String direccion;
	String coordenadas_dic;
	String foto;
	String descripcion;
	String tipo_costo;
	String costo;
	String capacidad_max;
	String tipo_inmueble;
	String estado;
	String usuarios_idusuario;
	String ranking_idranking;
	
	public Inmueble(int idinmueble, String direccion, String coordenadas_dic, String foto, String descripcion,
			String tipo_costo, String costo, String capacidad_max, String tipo_inmueble, String estado,
			String usuarios_idusuario, String ranking_idranking) {
		super();
		this.idinmueble = idinmueble;
		this.direccion = direccion;
		this.coordenadas_dic = coordenadas_dic;
		this.foto = foto;
		this.descripcion = descripcion;
		this.tipo_costo = tipo_costo;
		this.costo = costo;
		this.capacidad_max = capacidad_max;
		this.tipo_inmueble = tipo_inmueble;
		this.estado = estado;
		this.usuarios_idusuario = usuarios_idusuario;
		this.ranking_idranking = ranking_idranking;
	}

	public Inmueble() {
		super();
	}

	public int getIdinmueble() {
		return idinmueble;
	}

	public void setIdinmueble(int idinmueble) {
		this.idinmueble = idinmueble;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getCoordenadas_dic() {
		return coordenadas_dic;
	}

	public void setCoordenadas_dic(String coordenadas_dic) {
		this.coordenadas_dic = coordenadas_dic;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getTipo_costo() {
		return tipo_costo;
	}

	public void setTipo_costo(String tipo_costo) {
		this.tipo_costo = tipo_costo;
	}

	public String getCosto() {
		return costo;
	}

	public void setCosto(String costo) {
		this.costo = costo;
	}

	public String getCapacidad_max() {
		return capacidad_max;
	}

	public void setCapacidad_max(String capacidad_max) {
		this.capacidad_max = capacidad_max;
	}

	public String getTipo_inmueble() {
		return tipo_inmueble;
	}

	public void setTipo_inmueble(String tipo_inmueble) {
		this.tipo_inmueble = tipo_inmueble;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getUsuarios_idusuario() {
		return usuarios_idusuario;
	}

	public void setUsuarios_idusuario(String usuarios_idusuario) {
		this.usuarios_idusuario = usuarios_idusuario;
	}

	public String getRanking_idranking() {
		return ranking_idranking;
	}

	public void setRanking_idranking(String ranking_idranking) {
		this.ranking_idranking = ranking_idranking;
	}

	@Override
	public String toString() {
		return "Inmueble [idinmueble=" + idinmueble + ", direccion=" + direccion + ", coordenadas_dic=" + coordenadas_dic
				+ ", foto=" + foto + ", descripcion=" + descripcion + ", tipo_costo=" + tipo_costo + ", costo=" + costo
				+ ", capacidad_max=" + capacidad_max + ", tipo_inmueble=" + tipo_inmueble + ", estado=" + estado
				+ ", usuarios_idusuario=" + usuarios_idusuario + ", ranking_idranking=" + ranking_idranking + "]";
	}
}
