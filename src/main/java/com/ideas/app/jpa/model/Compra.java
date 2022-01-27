package com.ideas.app.jpa.model;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="COMPRA")
public class Compra {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="COMPRA_COD")
	private Integer codigo;
	
	@Column(name="COMPRA_FEC")
	private String fecha;
	
	@Column(name="COMPRA_NU_B")
	private int numBoletos;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "COMPRA_FK_CLI")
	private Cliente cliente;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "COMPRA_FK_DES")
	private Destino destino;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "COMPRA_FK_TRA")
	private Transporte transporte;
	
		
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "COMPRA_FK_EMP")
	private Empleado empleado;
	
	
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "compra")
	private Factura factura;
	
	
	@Transient
	private Map<Integer, String> mapClientes;
	
	@Transient
	private Map<Integer, String> mapDestinos;
	
	@Transient
	private Map<Integer, String> mapTransportes;
	
	@Transient
	private Map<Integer, String> mapEmpleados;
	
	public Compra() {
		
	   initMaps();
	}

	

	public Compra(Integer codigo, String fecha, int numBoletos) {
	
		this.codigo = codigo;
		this.fecha = fecha;
		this.numBoletos = numBoletos;
		
		initMaps();
	}

	private void initMaps() {
		mapClientes = new HashMap<Integer,String>();
		mapDestinos = new HashMap<Integer,String>();
		mapTransportes = new HashMap<Integer,String>();
		mapEmpleados = new HashMap<Integer,String>();
	}

	public Integer getCodigo() {
		return codigo;
	}


	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}


	public String getFecha() {
		return fecha;
	}


	public void setFecha(String fecha) {
		this.fecha = fecha;
	}


	public int getNumBoletos() {
		return numBoletos;
	}

	public void setNumBoletos(int numBoletos) {
		this.numBoletos = numBoletos;
	}


	public Cliente getCliente() {
		return cliente;
	}


	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}


	public Destino getDestino() {
		return destino;
	}


	public void setDestino(Destino destino) {
		this.destino = destino;
	}


	public Transporte getTransporte() {
		return transporte;
	}


	public void setTransporte(Transporte transporte) {
		this.transporte = transporte;
	}


	public Empleado getEmpleado() {
		return empleado;
	}


	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}


	
	public Map<Integer, String> getMapClientes() {
		return mapClientes;
	}

	public void setMapClientes(Map<Integer, String> mapClientes) {
		this.mapClientes = mapClientes;
	}



	public Map<Integer, String> getMapDestinos() {
		return mapDestinos;
	}



	public void setMapDestinos(Map<Integer, String> mapDestinos) {
		this.mapDestinos = mapDestinos;
	}



	public Map<Integer, String> getMapTransportes() {
		return mapTransportes;
	}



	public void setMapTransportes(Map<Integer, String> mapTransportes) {
		this.mapTransportes = mapTransportes;
	}



	public Map<Integer, String> getMapEmpleados() {
		return mapEmpleados;
	}
	
	public void setMapEmpleados(Map<Integer, String> mapEmpleados) {
		this.mapEmpleados = mapEmpleados;
	}


   
	public Factura getFactura() {
		return factura;
	}

	public void setFactura(Factura factura) {
		this.factura = factura;
	}

	
	@Override
	public String toString() {
		return "Compra [codigo=" + codigo + ", fecha=" + fecha + ", numBoletos=" + numBoletos +
				", Cliente= "+cliente.getCodigo()+ ", Empleado= "+  empleado.getCodigo()+ ", Destino: " +destino.getCodigo()+
				", Transporte= "+transporte.getCodigo()+  ", Factura: "+factura.getCodigo()+  "]";
	}

	
}
