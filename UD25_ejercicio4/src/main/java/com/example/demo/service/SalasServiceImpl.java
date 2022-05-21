package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.SalasDAO;
import com.example.demo.dto.Salas;

@Service
public class SalasServiceImpl implements SalasService{

	// Utilizar metodos DAO heredados de JPA
	@Autowired
	SalasDAO salasDao;

	@Override
	public List<Salas> listarSalas() {
		return salasDao.findAll();
	}

	@Override
	public Salas crearSalas(Salas sala) {
		return salasDao.save(sala);
	}

	@Override
	public Salas modificarSalas(Salas sala) {
		return salasDao.save(sala);
	}

	@Override
	public void eliminarSalas(Long codigo) {
		salasDao.deleteById(codigo);
	}

	@Override
	public Salas buscarSalas(Long codigo) {
		return salasDao.findById(codigo).get();
	}

}
