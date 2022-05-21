package com.example.demo.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="peliculas")// En caso que la tabla sea diferente
public class Peliculas {
	
	@Id
	private Long codigo;
	
	@Column(name="nombre_pelicula")
	private String nombre_pelicula;
	
	@Column(name="calificacion_edad")
	private int calificacion_edad;

	// One to many
	@OneToMany
	@JoinColumn(name="codigo")
	private List<Salas> salas;
	
	//Constructores
	public Peliculas() {

	}

	/**
	 * 
	 * @param codigo
	 * @param nombrePelicula
	 * @param calificacionEdad
	 */
	public Peliculas(Long codigo, String nombre_pelicula, int calificacion_edad) {
		this.codigo = codigo;
		this.nombre_pelicula = nombre_pelicula;
		this.calificacion_edad = calificacion_edad;
	}

	// Getters y setters
	/**
	 * 
	 * @return de id
	 */
	public Long getCodigo() {
		return codigo;
	}

	/**
	 * 
	 * @param codigo
	 */
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	/**
	 * 
	 * @return de nombre
	 */
	public String getNombre() {
		return nombre_pelicula;
	}

	/**
	 * 
	 * @param nombre
	 */
	public void setNombre(String nombre_pelicula) {
		this.nombre_pelicula = nombre_pelicula;
	}

	/**
	 * 
	 * @return de CalificacionEdad
	 */
	public int getCalificacionEdad() {
		return calificacion_edad;
	}

	/**
	 * 
	 * @param calificacionEdad
	 */
	public void setCalificacionEdad(int calificacion_edad) {
		this.calificacion_edad = calificacion_edad;
	}

	// Metodo impresion de datos por consola
	@Override
	public String toString() {
		return "Peliculas [codigo=" + codigo + ", nombre=" + nombre_pelicula + ", CalificacionEdad=" + calificacion_edad + "]";
	}	
	
	@JsonIgnore
	@OneToMany (fetch = FetchType.LAZY, mappedBy = "Salas")
	public List<Salas> getSalas(){
		return salas;
	}

	public void setSalas(List<Salas> salas) {
		this.salas = salas;
	}	
}
