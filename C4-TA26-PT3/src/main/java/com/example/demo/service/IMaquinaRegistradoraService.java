package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.MaquinaRegistradora;

public interface IMaquinaRegistradoraService {

	// Metodos del CRUD
	public List<MaquinaRegistradora> listarMaquinasRegistradoras(); // Listar All

	public MaquinaRegistradora guardarMaquinaRegistradora(MaquinaRegistradora maquinaRegistradora); // Guarda una MaquinaRegistradora (CREATE)

	public MaquinaRegistradora maquinaRegistradoraXID(int id); // Lee datos de una MaquinaRegistradora (READ)

	public MaquinaRegistradora actualizarMaquinaRegistradora(MaquinaRegistradora maquinaRegistradora); // Actualiza datos de la maquinaRegistradora (UPDATE)

	public void eliminarMaquinaRegistradora(int id);// Elimina la maquinaRegistradora (DELETE)

}
