package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.Cajero;

public interface ICajeroService {

	// Metodos del CRUD
	public List<Cajero> listarCajeros(); // Listar All

	public Cajero guardarCajero(Cajero cajero); // Guarda una Cajero (CREATE)

	public Cajero cajeroXID(int id); // Lee datos de una Cajero (READ)

	public Cajero actualizarCajero(Cajero cajero); // Actualiza datos de la cajero (UPDATE)

	public void eliminarCajero(int id);// Elimina la cajero (DELETE)

}
