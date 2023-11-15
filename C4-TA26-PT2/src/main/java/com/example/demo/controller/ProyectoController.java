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
import com.example.demo.dto.Proyecto;
import com.example.demo.service.ProyectoServiceImpl;

@RestController
@RequestMapping("/api")
public class ProyectoController {
	
	@Autowired
	ProyectoServiceImpl proyectoServiceImpl;
	
	@GetMapping("/proyectos")
	public List<Proyecto> listarCproyectos(){
		return proyectoServiceImpl.listarProyectos();
	}
	
	@PostMapping("/proyectos")
	public Proyecto salvarProyecto(@RequestBody Proyecto proyecto) {
		return proyectoServiceImpl.guardarProyecto(proyecto);
	}
	
	@GetMapping("/proyectos/{id}")
	public Proyecto proyectoXID(@PathVariable(name="id") String id) {
		Proyecto Proyecto_x_id = new Proyecto();
		Proyecto_x_id = proyectoServiceImpl.proyectoXID(id);
		
		System.out.println("Proyecto X id: " + Proyecto_x_id);
		return Proyecto_x_id;
	}
	
	@PutMapping("/proyectos/{id}")
	public Proyecto actualizarProyecto(@PathVariable(name="id")String id,@RequestBody Proyecto proyecto) {
		Proyecto Proyecto_seleccionado = new Proyecto();
		Proyecto Proyecto_actualizado = new Proyecto();
		
		Proyecto_seleccionado = proyectoServiceImpl.proyectoXID(id);
		
		Proyecto_seleccionado.setNombre(proyecto.getNombre());
		Proyecto_seleccionado.setHoras(proyecto.getHoras());
		
		Proyecto_actualizado = proyectoServiceImpl.actualizarProyecto(Proyecto_seleccionado);
		
		System.out.println("El Proyecto actualizado es: " + Proyecto_actualizado);
		return Proyecto_actualizado;
	}
	
	@DeleteMapping("/proyectos/{id}")
	public void eleiminarProyecto(@PathVariable(name="id")String id) {
		proyectoServiceImpl.eliminarProyecto(id);
	}
	
}
