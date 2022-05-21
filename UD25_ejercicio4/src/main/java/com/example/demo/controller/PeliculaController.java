package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.Peliculas;
import com.example.demo.service.PeliculaServiceImpl;

@RestController
@RequestMapping("/api") //Raiz de la app
public class PeliculaController {
	@Autowired
	PeliculaServiceImpl peliculaServiceImpl;
	
	// Listar todas las salas
	@GetMapping("/peliculas")
	public List<Peliculas> listarPeliculas(){
		return peliculaServiceImpl.listarPeliculas();
	}
	
	// Buscar las salas por id
	@GetMapping("/peliculas/{id}")
	public Peliculas buscarSalaCodigo(@PathVariable(name= "id")Long codigo) {
		return peliculaServiceImpl.buscarPeliculas(codigo);		
	}
	
	// Eliminar una sala
	@GetMapping("/peliculas/{id}")
	public void eliminarSalas(@PathVariable(name="id")Long codigo) {
		peliculaServiceImpl.eliminarPeliculas(codigo);
	}
	
	// Crear sala
	@PostMapping("/peliculas")
	public Peliculas crearPeliculas(@RequestBody Peliculas peliculas) {
		return peliculaServiceImpl.crearPeliculas(peliculas);
	}
	
	// Modificar sala
	@PutMapping("/peliculas/{id")
	public Peliculas modificarPeliculas (@PathVariable(name="id")Long codigo, @RequestBody Peliculas peliculas) {
		Peliculas pelicula_a_modificar = new Peliculas();
		Peliculas modificado = new Peliculas();
		
		// Busco el id de la sala que quiero cambiar
		pelicula_a_modificar = peliculaServiceImpl.buscarPeliculas(codigo);
		
		pelicula_a_modificar.setCodigo(peliculas.getCodigo());
		pelicula_a_modificar.setNombre(peliculas.getNombre());
		pelicula_a_modificar.setCalificacionEdad(peliculas.getCalificacionEdad());
		
		// Modificado es = a los cambios aplicados
		modificado = peliculaServiceImpl.modificarPeliculas(pelicula_a_modificar);
		
		return modificado;
		
	}
}
