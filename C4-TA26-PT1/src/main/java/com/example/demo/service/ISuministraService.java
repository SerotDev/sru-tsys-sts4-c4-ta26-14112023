package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.Suministra;

public interface ISuministraService {

	//Metodos del CRUD
		public List<Suministra> listarSuministra(); //Listar All 
		
		public Suministra guardarSuministra(Suministra suministra);	//Guarda un Suministra CREATE
		
		public Suministra suministraXID(int id); //Leer datos de un Suministra READ
		
		public Suministra actualizarSuministra(Suministra suministra); //Actualiza datos del Suministra UPDATE
		
		public void eliminarSuministra(int id);// Elimina el Suministra DELETE
	
}


