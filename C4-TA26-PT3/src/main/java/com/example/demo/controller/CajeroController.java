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
import com.example.demo.dto.Cajero;
import com.example.demo.service.CajeroServiceImpl;

@RestController
@RequestMapping("/api")
public class CajeroController {
	
	@Autowired
	CajeroServiceImpl cajeroServiceImpl;
	
	@GetMapping("/cajeros")
	public List<Cajero> listarCajero(){
		return cajeroServiceImpl.listarCajeros();
	}
	
	@PostMapping("/cajeros")
	public Cajero salvarCajero(@RequestBody Cajero proveedor) {
		return cajeroServiceImpl.guardarCajero(proveedor);
	}
	
	@GetMapping("/cajeros/{id}")
	public Cajero CajeroXID(@PathVariable(name="id") int id) {
		Cajero Cajero_x_id = new Cajero();
		Cajero_x_id = cajeroServiceImpl.cajeroXID(id);
		
		System.out.println("Cajero X id: " + Cajero_x_id);
		return Cajero_x_id;
	}
	
	@PutMapping("/cajeros/{id}")
	public Cajero actualizarCajero(@PathVariable(name="id")int id,@RequestBody Cajero Cajero) {
		Cajero Cajero_seleccionado = new Cajero();
		Cajero Cajero_actualizado = new Cajero();
		
		Cajero_seleccionado = cajeroServiceImpl.cajeroXID(id);
		
		Cajero_seleccionado.setNomApels(Cajero.getNomApels());
		
		Cajero_actualizado = cajeroServiceImpl.actualizarCajero(Cajero_seleccionado);
		
		System.out.println("El Cajero actualizada es: " + Cajero_actualizado);
		return Cajero_actualizado;
	}
	
	@DeleteMapping("/cajeros/{id}")
	public void eleiminarCajero(@PathVariable(name="id")int id) {
		cajeroServiceImpl.eliminarCajero(id);
	}
	
}
