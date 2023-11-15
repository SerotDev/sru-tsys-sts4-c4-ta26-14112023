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
@Table(name="suministra")//en caso que la tabala sea diferente
public class Suministra {
	//Atributos de entidad suministra
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//busca ultimo valor e incrementa desde id final de db
	private int id;
	
	@ManyToOne
    @JoinColumn(name = "id_pieza")
    Pieza pieza;
 
    @ManyToOne
    @JoinColumn(name = "id_proveedor")
    Proveedor proveedor;
	
	@Column(name = "precio")
	private int precio;
	
	//Constructores
	public Suministra() {
	}

	/**
	 * @param id
	 * @param pieza
	 * @param proveedor
	 * @param precio
	 */
	public Suministra(int id, Pieza pieza, Proveedor proveedor, int precio) {
		this.id = id;
		this.pieza = pieza;
		this.proveedor = proveedor;
		this.precio = precio;
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
	 * @return return the pieza
	 */
	public Pieza getPieza() {
		return pieza;
	}

	/**
	 * @param pieza set the pieza
	 */
	public void setPieza(Pieza pieza) {
		this.pieza = pieza;
	}

	/**
	 * @return return the proveedor
	 */
	public Proveedor getProveedor() {
		return proveedor;
	}

	/**
	 * @param proveedor set the proveedor
	 */
	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
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
	
	
	//Sobreescritura del metodo toString
	@Override
	public String toString() {
		return "Suministra [id=" + id + ", pieza=" + pieza + ", proveedor=" + proveedor + ", precio=" + precio + "]";
	}

}
