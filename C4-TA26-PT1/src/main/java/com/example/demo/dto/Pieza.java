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
@Table(name="piezas")//en caso que la tabala sea diferente
public class Pieza {
	//Atributos de entidad pieza
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//busca ultimo valor e incrementa desde id final de db
	private int id;
	
	@Column(name = "nombre")
	private String nombre;
	
	@OneToMany
    @JoinColumn(name="id")
    private List<Suministra> suministra;
	
	//Constructores
	public Pieza() {
	}

	/**
	 * @param id
	 * @param nombre
	 * @param suministra
	 */
	public Pieza(int id, String nombre, List<Suministra> suministra) {
		this.id = id;
		this.nombre = nombre;
		this.suministra = suministra;
	}

	//Getters y Setters
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
	 * @return the suministra
	 */
	@JsonIgnore // Cierra recursividad
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Suministra") // Mapea la entidad
	public List<Suministra> getSuministra() {
		return suministra;
	}
	/**
	 * @param suministra set the suministra
	 */
	public void setSuministra(List<Suministra> suministra) {
		this.suministra = suministra;
	}
	
	//Sobreescritura del metodo toString
	@Override
	public String toString() {
		return "Pieza [id=" + id + ", nombre=" + nombre + "]";
	}
	
}