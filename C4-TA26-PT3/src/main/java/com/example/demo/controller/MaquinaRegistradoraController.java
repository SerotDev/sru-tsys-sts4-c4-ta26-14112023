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
import com.example.demo.dto.MaquinaRegistradora;
import com.example.demo.service.MaquinaRegistradoraServiceImpl;

@RestController
@RequestMapping("/api")
public class MaquinaRegistradoraController {
	
	@Autowired
	MaquinaRegistradoraServiceImpl maquinaRegistradoraServiceImpl;
	
	@GetMapping("/maquinasRegistradoras")
	public List<MaquinaRegistradora> listarMaquinasRegistradoras(){
		return maquinaRegistradoraServiceImpl.listarMaquinasRegistradoras();
	}
	
	@PostMapping("/maquinasRegistradoras")
	public MaquinaRegistradora salvarMaquinaRegistradora(@RequestBody MaquinaRegistradora producto) {
		return maquinaRegistradoraServiceImpl.guardarMaquinaRegistradora(producto);
	}
	
	@GetMapping("/maquinasRegistradoras/{id}")
	public MaquinaRegistradora MaquinaRegistradoraXID(@PathVariable(name="id") int id) {
		MaquinaRegistradora MaquinaRegistradora_x_id = new MaquinaRegistradora();
		MaquinaRegistradora_x_id = maquinaRegistradoraServiceImpl.maquinaRegistradoraXID(id);
		
		System.out.println("MaquinaRegistradora X id: " + MaquinaRegistradora_x_id);
		return MaquinaRegistradora_x_id;
	}
	
	@PutMapping("/maquinasRegistradoras/{id}")
	public MaquinaRegistradora actualizarMaquinaRegistradora(@PathVariable(name="id")int id,@RequestBody MaquinaRegistradora MaquinaRegistradora) {
		MaquinaRegistradora MaquinaRegistradora_seleccionado = new MaquinaRegistradora();
		MaquinaRegistradora MaquinaRegistradora_actualizado = new MaquinaRegistradora();
		
		MaquinaRegistradora_seleccionado = maquinaRegistradoraServiceImpl.maquinaRegistradoraXID(id);
		
		MaquinaRegistradora_seleccionado.setPiso(MaquinaRegistradora.getPiso());
		
		MaquinaRegistradora_actualizado = maquinaRegistradoraServiceImpl.actualizarMaquinaRegistradora(MaquinaRegistradora_seleccionado);
		
		System.out.println("La Maquina Registradora actualizada es: " + MaquinaRegistradora_actualizado);
		return MaquinaRegistradora_actualizado;
	}
	
	@DeleteMapping("/maquinasRegistradoras/{id}")
	public void eleiminarMaquinaRegistradora(@PathVariable(name="id")int id) {
		maquinaRegistradoraServiceImpl.eliminarMaquinaRegistradora(id);
	}
	
}
