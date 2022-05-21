package com.example.demo.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="peliculas")// En caso que la tabla sea diferente
public class Peliculas {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//busca ultimo valor y lo incrementa
	private Long codigo;
	@Column(name="nombrePelicula")
	private String nombrePelicula;
	@Column(name="CalificacionEdad")
	private int CalificacionEdad;

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
	public Peliculas(Long codigo, String nombrePelicula, int calificacionEdad) {
		this.codigo = codigo;
		this.nombrePelicula = nombrePelicula;
		CalificacionEdad = calificacionEdad;
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
		return nombrePelicula;
	}

	/**
	 * 
	 * @param nombre
	 */
	public void setNombre(String nombre) {
		this.nombrePelicula = nombre;
	}

	/**
	 * 
	 * @return de CalificacionEdad
	 */
	public int getCalificacionEdad() {
		return CalificacionEdad;
	}

	/**
	 * 
	 * @param calificacionEdad
	 */
	public void setCalificacionEdad(int calificacionEdad) {
		CalificacionEdad = calificacionEdad;
	}

	// Metodo impresion de datos por consola
	@Override
	public String toString() {
		return "Peliculas [codigo=" + codigo + ", nombre=" + nombrePelicula + ", CalificacionEdad=" + CalificacionEdad + "]";
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
