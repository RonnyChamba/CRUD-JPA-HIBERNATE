package com.ideas.app.jpa.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name ="FACTURA")
public class Factura {

	@Id
	// @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="FACTURA_COD")
	private Integer codigo;
	
	@Column(name="FACTURA_OBS")
	private String observacion;
	
	@Column(name="FACTURA_FEC")
	private String fecha;
	
	@Column(name="FACTURA_SUB")
	private double subtotal;
	
	@Column(name="FACTURA_TOT")
	private double total;
	
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	// @JoinColumn(name = "FACTURA_FK_COM")
	@JoinColumn(name = "FACTURA_COD")
	private Compra compra;
	
	
	
	public Factura() {}
	
	public Factura(String observacion, String fecha, double subtotal, double total) {
		
		this.observacion = observacion;
		this.fecha = fecha;
		this.subtotal = subtotal;
		this.total = total;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	
	
	public Compra getCompra() {
		return compra;
	}

	public void setCompra(Compra compra) {
		this.compra = compra;
	}

	@Override
	public String toString() {
		return "Factura [codigo=" + codigo + ", observacion=" + observacion + ", fecha=" + fecha + ", subtotal="
				+ subtotal + ", total=" + total + ", Compra = "+compra.getCodigo()+"  ]";
	}

}
