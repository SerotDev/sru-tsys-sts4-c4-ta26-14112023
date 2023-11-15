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
@Table(name="cajeros")//en caso que la tabala sea diferente
public class Cajero {
	//Atributos de entidad cajero
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//busca ultimo valor e incrementa desde id final de db
	private int id;
	
	@Column(name = "nom_apels")
	private String nomApels;
	
	@OneToMany
    @JoinColumn(name="id")
    private List<Asignado> asignado;
	
	//Constructores
	public Cajero() {
	}

	/**
	 * @param id
	 * @param nomApels
	 * @param asignado
	 */
	public Cajero(int id, String nomApels, List<Asignado> asignado) {
		this.id = id;
		this.nomApels = nomApels;
		this.asignado = asignado;
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
	 * @return return the nomApels
	 */
	public String getNomApels() {
		return nomApels;
	}

	/**
	 * @param nomApels sets the nomApels
	 */
	public void setNomApels(String nomApels) {
		this.nomApels = nomApels;
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
	 * @param asignado set the asignado
	 */
	public void setAsignado(List<Asignado> asignado) {
		this.asignado = asignado;
	}
	
	//Sobreescritura del metodo toString
	@Override
	public String toString() {
		return "Cajero [id=" + id + ", nombre=" + nomApels + "]";
	}
	
}