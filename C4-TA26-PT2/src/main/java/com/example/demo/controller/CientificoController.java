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
import com.example.demo.dto.Cientifico;
import com.example.demo.service.CientificoServiceImpl;

@RestController
@RequestMapping("/api")
public class CientificoController {
	
	@Autowired
	CientificoServiceImpl cientificoServiceImpl;
	
	@GetMapping("/cientificos")
	public List<Cientifico> listarCproyectos(){
		return cientificoServiceImpl.listarCientificos();
	}
	
	@PostMapping("/cientificos")
	public Cientifico salvarCientifico(@RequestBody Cientifico proyecto) {
		return cientificoServiceImpl.guardarCientifico(proyecto);
	}
	
	@GetMapping("/cientificos/{dni}")
	public Cientifico CientificoXID(@PathVariable(name="dni") String dni) {
		Cientifico Cientifico_x_dni = new Cientifico();
		Cientifico_x_dni = cientificoServiceImpl.cientificoXDNI(dni);
		
		System.out.println("Cientifico X dni: " + Cientifico_x_dni);
		return Cientifico_x_dni;
	}
	
	@PutMapping("/cientificos/{dni}")
	public Cientifico actualizarCientifico(@PathVariable(name="dni")String dni,@RequestBody Cientifico Cientifico) {
		Cientifico Cientifico_seleccionado = new Cientifico();
		Cientifico Cientifico_actualizado = new Cientifico();
		
		Cientifico_seleccionado = cientificoServiceImpl.cientificoXDNI(dni);
		
		Cientifico_seleccionado.setNomApels(Cientifico.getNomApels());
		
		Cientifico_actualizado = cientificoServiceImpl.actualizarCientifico(Cientifico_seleccionado);
		
		System.out.println("El Cientifico actualizado es: " + Cientifico_actualizado);
		return Cientifico_actualizado;
	}
	
	@DeleteMapping("/cientificos/{dni}")
	public void eleiminarCientifico(@PathVariable(name="dni")String dni) {
		cientificoServiceImpl.eliminarCientifico(dni);
	}
	
}
