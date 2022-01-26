package com.ideas.app.jpa.model;

import java.util.List;
import java.util.Objects;

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
@Table(name="TIPO_VIAJE")
public class TipoViaje {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="TIPO_VIAJE_COD")
	private Integer codigo;
	
	
	@Column(name="TIPO_VIAJE_TIP")
	private String tipo;
	
	@Column(name="TIPO_VIAJE_DES")
	private String descripcion;
	
	@Column(name="TIPO_VIAJE_PRE")
	private double precio;
	
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoViaje", fetch = FetchType.LAZY, orphanRemoval = true)
	private List<Destino> destinos;
	
	
	public TipoViaje() {}
	

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

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	
	
	public List<Destino> getDestinos() {
		return destinos;
	}


	public void setDestinos(List<Destino> destinos) {
		this.destinos = destinos;
	}

	

	@Override
	public int hashCode() {
		return Objects.hash(codigo, tipo, descripcion, precio);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TipoViaje other = (TipoViaje) obj;
		return Objects.equals(codigo, other.codigo) && Objects.equals(tipo, other.tipo);
	}


	@Override
	public String toString() {
		return "TipoViaje [codigo=" + codigo + ", tipo=" + tipo + ", descripcion=" + descripcion + ", precio=" + precio
				+ "]";
	}
	

}
