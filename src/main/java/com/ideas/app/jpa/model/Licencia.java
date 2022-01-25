package com.ideas.app.jpa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="LICENCIA")
public class Licencia {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="LICENCIA_COD")
	private Integer codigo;
	
	@Column(name="LICENCIA_TIP")
	private String tipo;
	
	@Column(name="LICENCIA_FE_I")
	private String fechaExpedicion;
	
	@Column(name="LICENCIA_FE_F")
	private String fechaExpiracion;
	
	@ManyToOne( fetch = FetchType.LAZY)
	@JoinColumn(name = "LICENCIA_FK_CON")
	private Conductor conductor;
	
	public Licencia() {}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getFechaExpedicion() {
		return fechaExpedicion;
	}

	public void setFechaExpedicion(String fechaExpedicion) {
		this.fechaExpedicion = fechaExpedicion;
	}

	public String getFechaExpiracion() {
		return fechaExpiracion;
	}

	public void setFechaExpiracion(String fechaExpiracion) {
		this.fechaExpiracion = fechaExpiracion;
	}

	public Conductor getConductor() {
		return conductor;
	}

	public void setConductor(Conductor conductor) {
		this.conductor = conductor;
	}

	@Override
	public String toString() {
		return "Licencia [codigo=" + codigo + ", tipo=" + tipo + ", fechaExpedicion=" + fechaExpedicion
				+ ", fechaExpiracion=" + fechaExpiracion + ", conductor=" + conductor.getCodigo() + "]";
	}
	
	
	
	
}
