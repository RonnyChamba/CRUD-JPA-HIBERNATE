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
@Table(name="DESTINO")
public class Destino {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="DESTINO_COD")
	private Integer codigo;
	
	@Column(name="DESTINO_LUG")
	private String lugar;
	
	@Column(name="DESTINO_DIR")
	private String direccion;
	
	@Column(name="DESTINO_CIU")
	private String ciudad;
	
	@Column(name="DESTINO_PAI")
	private String pais;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DESTINO_FK_TI_V")
	private TipoViaje tipoViaje;
	

	@Transient
	private Map<Integer, String> mapTipoViajes;
	
	
	public Destino() {
		mapTipoViajes = new HashMap<Integer, String>();
	
	}

	public Destino(String lugar, String direccion, String ciudad, String pais) {
		super();
		this.lugar = lugar;
		this.direccion = direccion;
		this.ciudad = ciudad;
		this.pais = pais;
		
		mapTipoViajes = new HashMap<Integer, String>();
	}
	

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getLugar() {
		return lugar;
	}

	public void setLugar(String lugar) {
		this.lugar = lugar;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}
	

	public TipoViaje getTipoViaje() {
		return tipoViaje;
	}

	public void setTipoViaje(TipoViaje tipoViaje) {
		this.tipoViaje = tipoViaje;
	}
	
	public Map<Integer, String> getMapTipoViajes() {
		return mapTipoViajes;
	}

	public void setMapTipoViajes(Map<Integer, String> mapTipoViajes) {
		this.mapTipoViajes = mapTipoViajes;
	}
	
	

	/*@Override
	public String toString() {
		return "Destino [codigo=" + codigo + ", lugar=" + lugar + ", direccion=" + direccion + ", ciudad=" + ciudad
				+ ", pais=" + pais + "]";
	}
	*/

	@Override
	public String toString() {
		return "Destino [codigo=" + codigo + ", lugar=" + lugar + ", direccion=" + direccion + ", ciudad=" + ciudad
				+ ", pais=" + pais +    ", Tipo viaje= "+tipoViaje+", MapTipoViajes = "+mapTipoViajes+" ]";
	}
	
	
	
	
	
	
	
}
