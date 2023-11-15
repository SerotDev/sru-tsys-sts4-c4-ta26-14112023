package com.example.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.dto.Proveedor;
import com.example.demo.service.ProveedorServiceImpl;

@RestController
@RequestMapping("/api")
public class ProveedorController {
	
	@Autowired
	ProveedorServiceImpl proveedorServiceImpl;
	
	@GetMapping("/proveedores")
	public List<Proveedor> listarCproveedors(){
		return proveedorServiceImpl.listarProveedors();
	}
	
	@PostMapping("/proveedores")
	public Proveedor salvarProveedor(@RequestBody Proveedor proveedor) {
		return proveedorServiceImpl.guardarProveedor(proveedor);
	}
	
	@GetMapping("/proveedores/{id}")
	public Proveedor proveedorXID(@PathVariable(name="id") String id) {
		Proveedor Proveedor_x_id = new Proveedor();
		Proveedor_x_id = proveedorServiceImpl.proveedorXID(id);
		
		System.out.println("Proveedor X id: " + Proveedor_x_id);
		return Proveedor_x_id;
	}
	
	@PutMapping("/proveedores/{id}")
	public Proveedor actualizarProveedor(@PathVariable(name="id")String id,@RequestBody Proveedor proveedor) {
		Proveedor Proveedor_seleccionado = new Proveedor();
		Proveedor Proveedor_actualizado = new Proveedor();
		
		Proveedor_seleccionado = proveedorServiceImpl.proveedorXID(id);
		
		Proveedor_seleccionado.setNombre(proveedor.getNombre());
		
		Proveedor_actualizado = proveedorServiceImpl.actualizarProveedor(Proveedor_seleccionado);
		
		System.out.println("El Proveedor actualizado es: " + Proveedor_actualizado);
		return Proveedor_actualizado;
	}
	
	@DeleteMapping("/proveedores/{id}")
	public void eleiminarProveedor(@PathVariable(name="id")String id) {
		proveedorServiceImpl.eliminarProveedor(id);
	}
	
}
