package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.Salas;

public interface SalasService {
	public List<Salas> listarSalas();

	public Salas crearSalas(Salas sala);

	public Salas modificarSalas(Salas sala);

	public void eliminarSalas(Long codigo);

	public Salas buscarSalas(Long codigo);
}
