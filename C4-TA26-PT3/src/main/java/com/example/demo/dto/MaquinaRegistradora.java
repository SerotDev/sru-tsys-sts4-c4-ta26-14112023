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
@Table(name="maquinas_registradoras")//en caso que la tabala sea diferente
public class MaquinaRegistradora {
	//Atributos de entidad maquinaRegistradora
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//busca ultimo valor e incrementa desde id final de db
	private int id;
	
	@Column(name = "piso")
	private int piso;
	
	@OneToMany
    @JoinColumn(name="id")
    private List<Asignado> asignado;
	
	//Constructores
	public MaquinaRegistradora() {
	}

	/**
	 * @param id
	 * @param piso
	 * @param asignado
	 */
	public MaquinaRegistradora(int id, int piso, List<Asignado> asignado) {
		this.id = id;
		this.piso = piso;
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
	 * @return return the piso
	 */
	public int getPiso() {
		return piso;
	}

	/**
	 * @param piso get the piso
	 */
	public void setPiso(int piso) {
		this.piso = piso;
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
		return "MaquinaRegistradora [id=" + id + ", piso=" + piso + "]";
	}
	
}