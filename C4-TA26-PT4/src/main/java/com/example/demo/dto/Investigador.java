package com.example.demo.dto;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="investigadores")//en caso que la tabala sea diferente
public class Investigador {
	//Atributos de entidad investigador
	@Id
	@Column(name = "dni")
	private String dni;
	
	@Column(name = "nom_apels")
	private String nomApels;
	
	@ManyToOne
    @JoinColumn(name = "facultad")
    Facultad facultad;
	
	@OneToMany
    @JoinColumn(name="id")
    private List<Reserva> reserva;
	
	//Constructores
	public Investigador() {
	}

	/**
	 * @param dni
	 * @param nomApels
	 * @param facultad
	 * @param reserva
	 */
	public Investigador(String dni, String nomApels, Facultad facultad, List<Reserva> reserva) {
		this.dni = dni;
		this.nomApels = nomApels;
		this.facultad = facultad;
		this.reserva = reserva;
	}


	//Getters y Setters
	/**
	 * @return returns the id
	 */
	public String getDni() {
		return dni;
	}

	/**
	 * @param id sets the id
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
	 * @param nomApels sets the nomApels
	 */
	public void setNomApels(String nomApels) {
		this.nomApels = nomApels;
	}
	
	/**
	 * @return return the facultad
	 */
	public Facultad getFacultad() {
		return facultad;
	}

	/**
	 * @param facultad set the facultad
	 */
	public void setFacultad(Facultad facultad) {
		this.facultad = facultad;
	}

	/**
	 * @return the reserva
	 */
	@JsonIgnore // Cierra recursividad
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Reserva") // Mapea la entidad
	public List<Reserva> getReserva() {
		return reserva;
	}
	/**
	 * @param reserva set the reserva
	 */
	public void setReserva(List<Reserva> reserva) {
		this.reserva = reserva;
	}

	
	//Sobreescritura del metodo toString
	@Override
	public String toString() {
		return "Investigador [dni=" + dni + ", nomApels=" + nomApels + ", facultad=" + facultad + "]";
	}
	
}