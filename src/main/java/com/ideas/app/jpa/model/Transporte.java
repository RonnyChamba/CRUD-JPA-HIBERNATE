package com.ideas.app.jpa.model;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="TRANSPORTE")
public class Transporte {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="TRANSPORTE_COD")
	private Integer codigo;
	
	@Column(name = "TRANSPORTE_MAT")
	private String matricula;
	
	@Column(name="TRANSPORTE_COL")
	private String color;
	
	@Column(name="TRANSPORTE_AG_F")
	private String agnioFabricacion;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TRANSPORTE_FK_TI_T")
	private TipoTransporte tipoTransporte;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="TRANSPORTE_FK_CON")
	private Conductor conductor;
	
	@Transient
	private Map<Integer, String> mapTransportes;
	
	@Transient
	private Map<Integer, String> mapConductores;
	
	
	public Transporte() {
	

		mapTransportes = new HashMap<Integer, String >();
		mapConductores = new HashMap<Integer, String>();
	}
	

	public Transporte(String matricula, String color, String agnioFabricacion, TipoTransporte tipoTransporte,
			Conductor conductor) {
		
		this.matricula = matricula;
		this.color = color;
		this.agnioFabricacion = agnioFabricacion;
		this.tipoTransporte = tipoTransporte;
		this.conductor = conductor;
	}



	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getAgnioFabricacion() {
		return agnioFabricacion;
	}

	public void setAgnioFabricacion(String agnioFabricacion) {
		this.agnioFabricacion = agnioFabricacion;
	}

	public TipoTransporte getTipoTransporte() {
		return tipoTransporte;
	}

	public void setTipoTransporte(TipoTransporte tipoTransporte) {
		this.tipoTransporte = tipoTransporte;
	}

	public Conductor getConductor() {
	
		return conductor;
	}

	public void setConductor(Conductor conductor) {
		
		this.conductor = conductor;
	}

	
	public void setMapConductores(Map<Integer, String> mapConductores) {
		this.mapConductores = mapConductores;
	}
	public Map<Integer, String> getMapConductores() {
		return mapConductores;
	}
	
	public void setMapTransportes(Map<Integer, String> mapTransportes) {
		this.mapTransportes = mapTransportes;
	}
	public Map<Integer, String> getMapTransportes() {
		return mapTransportes;
	}
	
	@Override
	public String toString() {
		return "Transporte [codigo=" + codigo + ", matricula=" + matricula + ", color=" + color + ", agnioFabricacion="
				+ agnioFabricacion + ", tipoTransporte=" + tipoTransporte + ", conductor=" + conductor
				+ ", mapTransportes=" + mapTransportes + ", mapConductores=" + mapConductores + "]";
	}

	
}
