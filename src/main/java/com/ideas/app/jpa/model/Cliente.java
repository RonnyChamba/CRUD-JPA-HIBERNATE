package com.ideas.app.jpa.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "CLIENTES")
public class Cliente {
	
	
	@Id
	@Column(name="CLIENTES_COD")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigo;
	
	@Column(name = "CLIENTES_CED")
	private String cedula;
	
	@Column(name = "CLIENTES_NOM")
	private String nombre;
	
	@Column(name = "CLIENTES_APE")
	private String apellido;
	
	@Column(name = "CLIENTES_DIR")
	private String direccion;
	
	@Column(name = "CLIENTES_EDA")
	private int edad;
	
	@Column(name = "CLIENTES_NAC")
	private String nacionalidad;
	
	@Column(name = "CLIENTES_ES_C")
	private String estadoCivil;
	
	@Column(name= "CLIENTES_TEL")
	private String telefono;
	
	@Column(name = "CLIENTES_ES_R")
	private String estudiosRealizados;
	
	@OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL,fetch = FetchType.LAZY, orphanRemoval = true)
	private List<Compra> compras = new ArrayList<Compra>();
	
	@Transient
	private Map<String, String> tiposEstados;
	
	
	public Cliente() {
		
		initEstadosCivil();
		
	}


	public Cliente(String cedula, String nombre, String apellido, int edad) {
		
		this.cedula = cedula;
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		
		initEstadosCivil();
	}


	public String getCedula() {
		return cedula;
	}


	public void setCedula(String cedula) {
		this.cedula = cedula;
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


	public String getDireccion() {
		return direccion;
	}


	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


	public int getEdad() {
		return edad;
	}


	public void setEdad(int edad) {
		this.edad = edad;
	}


	public String getEstadoCivil() {
		return estadoCivil;
	}


	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}


	public String getTelefono() {
		return telefono;
	}


	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}


	public String getNacionalidad() {
		return nacionalidad;
	}


	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}


	public String getEstudiosRealizados() {
		return estudiosRealizados;
	}


	public void setEstudiosRealizados(String estudiosRealizados) {
		this.estudiosRealizados = estudiosRealizados;
	}

	

	public Integer getCodigo() {
		return codigo;
	}


	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	
	public List<Compra> getCompras() {
		return compras;
	}


	public void setCompras(List<Compra> compras) {
		this.compras = compras;
	}


	@Override
	public String toString() {
		return "Cliente [codigo=" + codigo + ", cedula=" + cedula + ", nombre=" + nombre + ", apellido=" + apellido
				+ ", direccion=" + direccion + ", edad=" + edad + ", nacionalidad=" + nacionalidad + ", estadoCivil="
				+ estadoCivil + ", telefono=" + telefono + ", estudiosRealizados=" + estudiosRealizados
				+ ", tiposEstados=" + tiposEstados + "]";
	}


	private void initEstadosCivil() {
		
		tiposEstados = new HashMap<String, String>();
		
		tiposEstados.put("SOLTERO", "Soltero");
		tiposEstados.put("CASADO", "Casado");
		tiposEstados.put("VIUDO", "Viudo");
	}


	public Map<String, String> getTiposEstados() {
		return tiposEstados;
	}


	public void setTiposEstados(Map<String, String> tiposEstados) {
		this.tiposEstados = tiposEstados;
	}
	
	
	
	

}
