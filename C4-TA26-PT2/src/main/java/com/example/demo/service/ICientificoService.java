package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.Cientifico;

public interface ICientificoService {

	// Metodos del CRUD
	public List<Cientifico> listarCientificos(); // Listar All

	public Cientifico guardarCientifico(Cientifico cientifico); // Guarda una Cientifico (CREATE)

	public Cientifico cientificoXDNI(String dni); // Lee datos de una Cientifico (READ)

	public Cientifico actualizarCientifico(Cientifico cientifico); // Actualiza datos de la cientifico (UPDATE)

	public void eliminarCientifico(String dni);// Elimina la cientifico (DELETE)

}
