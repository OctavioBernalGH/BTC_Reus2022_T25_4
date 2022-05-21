package com.example.demo.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "salas") // En caso que la tabla sea diferente
public class Salas {

	@Id
	private Long codigo;
	
	@Column(name = "pelicula")
	private int pelicula;
	
	@Column(name = "nombre_sala")
	private String nombre_sala;

	@ManyToOne
	@JoinColumn(name = "id_peliculas")
	private Peliculas peliculas;

	// Constructores
	public Salas() {

	}

	/**
	 * 
	 * @param codigo
	 * @param nombreSala
	 * @param pelicula
	 */
	public Salas(Long codigo, String nombre_sala, int pelicula, Peliculas peliculas) {
		this.codigo = codigo;
		this.nombre_sala = nombre_sala;
		this.pelicula = pelicula;
		this.peliculas = peliculas;
	}

	// Getters y setters
	/**
	 * 
	 * @return de codigo
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
	 * @return de nombreSala
	 */
	public String getNombreSala() {
		return nombre_sala;
	}

	/**
	 * 
	 * @param nombreSala
	 */
	public void setNombreSala(String nombre_sala) {
		this.nombre_sala = nombre_sala;
	}

	/**
	 * 
	 * @return de pelicula
	 */
	public int getPelicula() {
		return pelicula;
	}

	/**
	 * 
	 * @param pelicula
	 */
	public void setPelicula(int pelicula) {
		this.pelicula = pelicula;
	}

	public Peliculas getPeliculas() {
		return peliculas;
	}

	public void setPeliculas(Peliculas peliculas) {
		this.peliculas = peliculas;
	}

	@Override
	public String toString() {
		return "Salas [codigo=" + codigo + ", nombreSala=" + nombre_sala + ", pelicula=" + pelicula + "]";
	}
}
