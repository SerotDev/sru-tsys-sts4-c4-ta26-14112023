package com.example.demo.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.dao.ICientificoDAO;
import com.example.demo.dto.Cientifico;

@Service
public class CientificoServiceImpl implements ICientificoService {
	
	@Autowired
	ICientificoDAO iCientificoDAO;

	@Override
	public List<Cientifico> listarCientificos() {
		return iCientificoDAO.findAll();
	}

	@Override
	public Cientifico guardarCientifico(Cientifico proyecto) {
		return iCientificoDAO.save(proyecto);
	}

	@Override
	public Cientifico cientificoXDNI(String dni) {
		return iCientificoDAO.findById(dni).get();
	}

	@Override
	public Cientifico actualizarCientifico(Cientifico proyecto) {
		return iCientificoDAO.save(proyecto);
	}

	@Override
	public void eliminarCientifico(String dni) {
		iCientificoDAO.deleteById(dni);
	}

}
