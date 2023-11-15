package com.example.demo.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.dao.IAsignadoDAO;
import com.example.demo.dto.Asignado;

@Service
public class AsignadoServiceImpl implements IAsignadoService {
	
	@Autowired
	IAsignadoDAO iAsignadoDAO;

	@Override
	public List<Asignado> listarAsignado() {
		return iAsignadoDAO.findAll();
	}

	@Override
	public Asignado guardarAsignado(Asignado producto) {
		return iAsignadoDAO.save(producto);
	}

	@Override
	public Asignado asignadoXID(int id) {
		return iAsignadoDAO.findById(id).get();
	}

	@Override
	public Asignado actualizarAsignado(Asignado producto) {
		return iAsignadoDAO.save(producto);
	}

	@Override
	public void eliminarAsignado(int id) {
		iAsignadoDAO.deleteById(id);
	}

}
