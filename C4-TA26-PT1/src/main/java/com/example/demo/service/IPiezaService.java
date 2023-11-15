package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.Pieza;

public interface IPiezaService {

	// Metodos del CRUD
	public List<Pieza> listarPiezas(); // Listar All

	public Pieza guardarPieza(Pieza pieza); // Guarda una Pieza (CREATE)

	public Pieza piezaXID(int id); // Lee datos de una Pieza (READ)

	public Pieza actualizarPieza(Pieza pieza); // Actualiza datos de la pieza (UPDATE)

	public void eliminarPieza(int id);// Elimina la pieza (DELETE)

}
