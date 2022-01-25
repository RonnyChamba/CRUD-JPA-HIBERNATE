package com.ideas.app.jpa.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "CONDUCTOR")
public class Conductor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CONDUCTOR_COD")
	private Integer codigo;

	@Column(name = "CONDUCTOR_CED")
	private String cedula;

	@Column(name = "CONDUCTOR_APE")
	private String apellido;

	@Column(name = "CONDUCTOR_NOM")
	private String nombre;

	@Column(name = "CONDUCTOR_TEL")
	private String telefono;

	
	@OneToMany(mappedBy = "conductor", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
	private List<Licencia> licencias;
	
	
	@OneToMany(mappedBy = "conductor", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
	private List<Transporte> transportes; 

	public Conductor() {
		licencias = new ArrayList<Licencia>();
		transportes = new ArrayList<Transporte>();
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	
	
	/*
	public void addLicencia(Licencia licencia) {

		if (!licencias.contains(licencia)) {

			licencias.add(licencia);
			licencia.setConductor(this);
		}

	}

	public void deleteLicencia(Licencia licencia) {
			
		   // Eliminar de la lista la licencia
		    licencias.remove(licencia);			
		    
		    // Desasociar la licencia del conductor
			// Lo que hara jpa será ubicar en la clave foranea de la licencia el valor de null, y gracias
		    // al atributo orphanRemoval = true, eliminara el registro de licencia , verifica que no puede haber una licencia sin que
		    // pertenesca a un conductor
		    licencia.setConductor(null);

	}

	 */
	public List<Licencia> getLicencias() {
		return licencias;
	}

	public void setLicencias(List<Licencia> licencias) {
		this.licencias = licencias;
	}

	public List<Transporte> getTransportes() {
		return transportes;
	}

	public void setTransportes(List<Transporte> transportes) {
		this.transportes = transportes;
	}

	@Override
	public String toString() {
		return "Conductor [codigo=" + codigo + ", cedula=" + cedula + ", apellido=" + apellido + ", nombre=" + nombre
				+ ", telefono=" + telefono + "]";
	}

}
