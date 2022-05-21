package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.dto.Peliculas;

// Repositorio de funcion es de base de datos
@Repository
public interface PeliculasDAO extends JpaRepository<Peliculas,Long>{
	
}
