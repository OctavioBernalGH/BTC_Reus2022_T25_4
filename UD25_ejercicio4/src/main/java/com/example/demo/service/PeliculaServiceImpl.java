package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.PeliculasDAO;
import com.example.demo.dto.Peliculas;

@Service
public class PeliculaServiceImpl implements PeliculaService{

	// Utilizar metodos DAO heredados de JPA
	@Autowired
	PeliculasDAO peliculasDao;

	@Override
	public List<Peliculas> listarPeliculas() {		
		return peliculasDao.findAll();
	}

	@Override
	public Peliculas crearPeliculas(Peliculas pelicula) {		
		return peliculasDao.save(pelicula);
	}

	@Override
	public Peliculas modificarPeliculas(Peliculas pelicula) {
		return peliculasDao.save(pelicula);
	}

	@Override
	public void eliminarPeliculas(Long codigo) {
		peliculasDao.deleteById(codigo);

	}

	@Override
	public Peliculas buscarPeliculas(Long codigo) {
		return peliculasDao.findById(codigo).get();
	}	
}
