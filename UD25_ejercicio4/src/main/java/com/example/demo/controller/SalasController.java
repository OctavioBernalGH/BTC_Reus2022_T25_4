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

import com.example.demo.dto.Salas;
import com.example.demo.service.SalasServiceImpl;

@RestController
@RequestMapping("/api") //Raiz de la app
public class SalasController {
	@Autowired
	SalasServiceImpl salasServiceImpl;
	
	// Listar todas las salas
	@GetMapping("/salas")
	public List<Salas> listarSalas(){
		return salasServiceImpl.listarSalas();
	}
	
	// Buscar las salas por id
	@GetMapping("/salas/{id}")
	public Salas buscarSalaCodigo(@PathVariable(name= "id")Long codigo) {
		return salasServiceImpl.buscarSalas(codigo);		
	}
	
	// Eliminar una sala
	@DeleteMapping("/salas/{id}")
	public void eliminarSalas(@PathVariable(name="id")Long codigo) {
		salasServiceImpl.eliminarSalas(codigo);
	}
	
	// Crear sala
	@PostMapping("/salas")
	public Salas crearSalas(@RequestBody Salas salas) {
		return salasServiceImpl.crearSalas(salas);
	}
	
	// Modificar sala
	@PutMapping("/salas/{id}")
	public Salas modificarSalas (@PathVariable(name="id")Long codigo, @RequestBody Salas salas) {
		Salas sala_a_modificar = new Salas();
		Salas modificado = new Salas();
		
		// Busco el id de la sala que quiero cambiar
		sala_a_modificar = salasServiceImpl.buscarSalas(codigo);
		
		sala_a_modificar.setCodigo(salas.getCodigo());
		sala_a_modificar.setNombreSala(salas.getNombreSala());
		sala_a_modificar.setPelicula(salas.getPelicula());
		sala_a_modificar.setPeliculas(salas.getPeliculas());
		
		// Modificado es = a los cambios aplicados
		modificado = salasServiceImpl.modificarSalas(sala_a_modificar);
		
		return modificado;
		
	}

}
