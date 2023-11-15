package com.example.demo.dto;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
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
@Table(name="cientificos")//en caso que la tabala sea diferente
public class Cientifico {
	//Atributos de entidad cientifico
	@Id
	@Column(name = "dni")
	private String dni;
	
	@Column(name = "nom_apels")
	private String nomApels;
	
	@OneToMany
    @JoinColumn(name="dni")
    private List<Asignado> asignado;
	
	
	//Constructores
	public Cientifico() {
	}

	public Cientifico(String dni, String nomApels, List<Asignado> asignado) {
		this.dni = dni;
		this.nomApels = nomApels;
		this.asignado = asignado;
	}

	
	//Getters y Setters
	/**
	 * @return return the dni
	 */
	public String getDni() {
		return dni;
	}

	/**
	 * @param dni set the dni
	 */
	public void setDni(String dni) {
		this.dni = dni;
	}

	/**
	 * @return return the nomApels
	 */
	public String getNomApels() {
		return nomApels;
	}
	
	
	/**
	 * @param nomApels set the nomApels
	 */
	public void setNomApels(String nomApels) {
		this.nomApels = nomApels;
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
	
	
	//Sobreescribe el metodo toString
	@Override
	public String toString() {
		return "Cientifico [dni=" + dni + ", nomApels=" + nomApels + "]";
	}
	
}