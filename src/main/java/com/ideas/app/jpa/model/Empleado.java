package com.ideas.app.jpa.model;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "EMPLEADOS")
public class Empleado {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "EMPLEADOS_COD")
	private Integer codigo;

	@Column(name = "EMPLEADOS_CED")
	private String cedula;

	@Column(name = "EMPLEADOS_NOM")
	private String nombre;

	@Column(name = "EMPLEADOS_APE")
	private String apellido;

	@Column(name = "EMPLEADOS_DIR")
	private String direccion;

	@Column(name = "EMPLEADOS_EDA")
	private int edad;

	@Column(name = "EMPLEADOS_ES_C")
	private String estadoCivil;

	@Column(name = "EMPLEADOS_TEL")
	private String telefono;

	@Column(name = "EMPLEADOS_SAL")
	private double salario;

	
	@Transient
	private Map<String, String> tiposEstados;
	
	public Empleado() {
		initEstadosCivil();
	}

	public Empleado(String cedula, String nombre, String apellido, int edad) {

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

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
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
	
	
	
	@Override
	public String toString() {
		return "Empleado [codigo=" + codigo + ", cedula=" + cedula + ", nombre=" + nombre + ", apellido=" + apellido
				+ ", direccion=" + direccion + ", edad=" + edad + ", estadoCivil=" + estadoCivil + ", telefono="
				+ telefono + ", salario=" + salario + "]";
	}

}
