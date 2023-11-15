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
import com.example.demo.dto.Pieza;
import com.example.demo.service.PiezaServiceImpl;

@RestController
@RequestMapping("/api")
public class PiezaController {
	
	@Autowired
	PiezaServiceImpl piezaServiceImpl;
	
	@GetMapping("/piezas")
	public List<Pieza> listarCproveedors(){
		return piezaServiceImpl.listarPiezas();
	}
	
	@PostMapping("/piezas")
	public Pieza salvarPieza(@RequestBody Pieza proveedor) {
		return piezaServiceImpl.guardarPieza(proveedor);
	}
	
	@GetMapping("/piezas/{id}")
	public Pieza PiezaXID(@PathVariable(name="id") int id) {
		Pieza Pieza_x_id = new Pieza();
		Pieza_x_id = piezaServiceImpl.piezaXID(id);
		
		System.out.println("Pieza X id: " + Pieza_x_id);
		return Pieza_x_id;
	}
	
	@PutMapping("/piezas/{id}")
	public Pieza actualizarPieza(@PathVariable(name="id")int id,@RequestBody Pieza Pieza) {
		Pieza Pieza_seleccionado = new Pieza();
		Pieza Pieza_actualizado = new Pieza();
		
		Pieza_seleccionado = piezaServiceImpl.piezaXID(id);
		
		Pieza_seleccionado.setNombre(Pieza.getNombre());
		
		Pieza_actualizado = piezaServiceImpl.actualizarPieza(Pieza_seleccionado);
		
		System.out.println("El Pieza actualizada es: " + Pieza_actualizado);
		return Pieza_actualizado;
	}
	
	@DeleteMapping("/piezas/{id}")
	public void eleiminarPieza(@PathVariable(name="id")int id) {
		piezaServiceImpl.eliminarPieza(id);
	}
	
}
