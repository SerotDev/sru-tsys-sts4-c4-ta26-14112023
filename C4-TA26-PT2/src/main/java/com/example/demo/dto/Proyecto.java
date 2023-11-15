package com.example.demo.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "proyectos") // en caso que la tabala sea diferente
public class Proyecto {
	// Atributos de entidad proyecto
	@Id
	private String id;

	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "horas")
	private int horas;
	
	@OneToMany
	@JoinColumn(name = "id")
	private List<Asignado> asignado;

	// Constructores
	public Proyecto() {
	}
	
	public Proyecto(String id, String nombre, int horas, List<Asignado> asignado) {
		this.id = id;
		this.nombre = nombre;
		this.horas = horas;
		this.asignado = asignado;
	}

	// Getters y Setters
	/**
	 * @return returns the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id sets the id
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return returns the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre sets the nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	/**
	 * @return retun the horas
	 */
	public int getHoras() {
		return horas;
	}

	/**
	 * @param horas set the horas
	 */
	public void setHoras(int horas) {
		this.horas = horas;
	}

	/**
	 * @return return the asignado
	 */
	@JsonIgnore // Cierra recursividad
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Asignado", cascade = CascadeType.ALL, orphanRemoval = true) // Mapea la entidad
	public List<Asignado> getAsignado() {
		return asignado;
	}

	/**
	 * @param asignado set the asignado
	 */
	public void setAsignado(List<Asignado> asignado) {
		this.asignado = asignado;
	}
	
	// Sobreescritura del metodo toString
	@Override
	public String toString() {
		return "Proyecto [id=" + id + ", nombre=" + nombre + "]";
	}

}
