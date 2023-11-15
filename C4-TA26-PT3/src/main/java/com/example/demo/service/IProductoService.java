package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.Producto;

public interface IProductoService {

	// Metodos del CRUD
	public List<Producto> listarProductos(); // Listar All

	public Producto guardarProducto(Producto producto); // Guarda un Producto (CREATE)

	public Producto productoXID(int id); // Lee datos de un Producto (READ)

	public Producto actualizarProducto(Producto producto); // Actualiza datos del Producto (UPDATE)

	public void eliminarProducto(int id);// Elimina el Producto (DELETE)

}
