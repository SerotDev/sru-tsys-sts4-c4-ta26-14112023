package com.example.demo.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="asignado_a")//en caso que la tabala sea diferente
public class Asignado {
	//Atributos de entidad asignado
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//busca ultimo valor e incrementa desde id final de db
	private int id;
	
	@ManyToOne
    @JoinColumn(name = "dni_cientifico")
    Cientifico cientifico;
 
    @ManyToOne
    @JoinColumn(name = "id_proyecto")
    Proyecto proyecto;
    
	
	//Constructores
	public Asignado() {
	}

	/**
	 * @param id
	 * @param cientifico
	 * @param proyecto
	 */
	public Asignado(int id, Cientifico cientifico, Proyecto proyecto) {
		this.id = id;
		this.cientifico = cientifico;
		this.proyecto = proyecto;
	}

	//Getters y Setters
	/**
	 * @return return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id set the id
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * @return return the cientifico
	 */
	public Cientifico getCientifico() {
		return cientifico;
	}

	/**
	 * @param cientifico set the cientifico
	 */
	public void setCientifico(Cientifico cientifico) {
		this.cientifico = cientifico;
	}

	/**
	 * @return return the proyecto
	 */
	public Proyecto getProyecto() {
		return proyecto;
	}

	/**
	 * @param proyecto set the proyecto
	 */
	public void setProyecto(Proyecto proyecto) {
		this.proyecto = proyecto;
	}
	
	
	//Sobreescritura del metodo toString
	@Override
	public String toString() {
		return "Asignado [id=" + id + ", cientifico=" + cientifico + ", proyecto=" + proyecto + "]";
	}
	
}
