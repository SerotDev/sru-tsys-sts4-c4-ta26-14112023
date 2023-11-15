package com.example.demo.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "productos") // en caso que la tabala sea diferente
public class Producto {
	// Atributos de entidad producto
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "precio")
	private int precio;
	
	@OneToMany
	@JoinColumn(name = "id")
	private List<Asignado> asignado;

	// Constructores
	public Producto() {
	}
	
	/**
	 * @param id
	 * @param nombre
	 * @param precio
	 * @param asignado
	 */
	public Producto(int id, String nombre, int precio, List<Asignado> asignado) {
		this.id = id;
		this.nombre = nombre;
		this.precio = precio;
		this.asignado = asignado;
	}


	// Getters y Setters
	/**
	 * @return returns the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id sets the id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return returns the name
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre sets the name
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return return the precio
	 */
	public int getPrecio() {
		return precio;
	}

	/**
	 * @param precio set the precio
	 */
	public void setPrecio(int precio) {
		this.precio = precio;
	}

	/**
	 * @return the asignado
	 */
	@JsonIgnore // Cierra recursividad
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Asignado") // Mapea la entidad
	public List<Asignado> getAsignado() {
		return asignado;
	}

	/**
	 * @param asignado the asignado to set
	 */
	public void setAsignado(List<Asignado> asignado) {
		this.asignado = asignado;
	}
	
	// Sobreescritura del metodo toString
	@Override
	public String toString() {
		return "Producto [id=" + id + ", nombre=" + nombre + ", precio=" + precio + "]";
	}

}
