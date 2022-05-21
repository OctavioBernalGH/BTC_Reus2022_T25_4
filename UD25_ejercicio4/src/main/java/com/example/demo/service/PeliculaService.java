package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.Peliculas;

public interface PeliculaService {
	public List<Peliculas> listarPeliculas();

	public Peliculas crearPeliculas(Peliculas pelicula);

	public Peliculas modificarPeliculas(Peliculas pelicula);

	public void eliminarPeliculas(Long codigo);

	public Peliculas buscarPeliculas(Long codigo);

}
