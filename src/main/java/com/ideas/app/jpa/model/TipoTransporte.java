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
@Table(name ="TIPO_TRANSPORTE")
public class TipoTransporte {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="TIPO_TRANSPORTE_COD")
	private Integer codigo;
	
	@Column(name="TIPO_TRANSPORTE_NOM")
	private String  tipo;
	
	@Column(name="TIPO_TRANSPORTE_ASI")
	private int asientos;
	
	
	@OneToMany( mappedBy = "tipoTransporte", fetch = FetchType.LAZY, orphanRemoval = true,cascade = CascadeType.ALL)
	private List<Transporte> transportes;
	
	
	public TipoTransporte() {
		transportes = new ArrayList<Transporte>();
		
	}

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

	public int getAsientos() {
		return asientos;
	}

	public void setAsientos(int asientos) {
		this.asientos = asientos;
	}

	public List<Transporte> getTransportes() {
		return transportes;
	}

	public void setTransportes(List<Transporte> transportes) {
		this.transportes = transportes;
	}

	
	
	@Override
	public String toString() {
		return "TipoTransporte [codigo=" + codigo + ", tipo=" + tipo + ", asientos=" + asientos + "]";
	}
	
	
	
	
	
	
	
	
}
