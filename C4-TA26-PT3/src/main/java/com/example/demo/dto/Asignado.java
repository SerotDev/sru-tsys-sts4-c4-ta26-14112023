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
	 @JoinColumn(name = "id_cajero")
	 Cajero cajero;
	
	@ManyToOne
    @JoinColumn(name = "id_maquina")
    MaquinaRegistradora maquinaRegistradora;
 
    @ManyToOne
    @JoinColumn(name = "id_producto")
    Producto producto;
	
	//Constructores
	public Asignado() {
	}

	/**
	 * @param id
	 * @param cajero
	 * @param maquinaRegistradora
	 * @param producto
	 */
	public Asignado(int id, Cajero cajero, MaquinaRegistradora maquinaRegistradora, Producto producto) {
		this.id = id;
		this.cajero = cajero;
		this.maquinaRegistradora = maquinaRegistradora;
		this.producto = producto;
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
	 * @return return the cajero
	 */
	public Cajero getCajero() {
		return cajero;
	}

	/**
	 * @param cajero set the cajero
	 */
	public void setCajero(Cajero cajero) {
		this.cajero = cajero;
	}
	
	/**
	 * @return return the maquinaRegistradora
	 */
	public MaquinaRegistradora getMaquinaRegistradora() {
		return maquinaRegistradora;
	}

	/**
	 * @param maquinaRegistradora set the maquinaRegistradora
	 */
	public void setMaquinaRegistradora(MaquinaRegistradora maquinaRegistradora) {
		this.maquinaRegistradora = maquinaRegistradora;
	}

	/**
	 * @return return the producto
	 */
	public Producto getProducto() {
		return producto;
	}

	/**
	 * @param producto set the producto
	 */
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	
	
	//Sobreescritura del metodo toString
	@Override
	public String toString() {
		return "Asignado [id=" + id + ", cajero=" + cajero + ", maquinaRegistradora=" + maquinaRegistradora
				+ ", producto=" + producto + "]";
	}

}
