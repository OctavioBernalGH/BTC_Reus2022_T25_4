package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.dto.Peliculas;

// Repositorio de funcion es de base de datos
public interface PeliculasDAO extends JpaRepository<Peliculas,Long>{
	
}
