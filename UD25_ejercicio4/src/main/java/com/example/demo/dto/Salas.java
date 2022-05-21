package com.example.demo.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="salas")// En caso que la tabla sea diferente
public class Salas {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//busca ultimo valor y lo incrementa
	private Long codigo;
	@Column (name="pelicula")
	private int pelicula;
	@ManyToOne // Creamos una relacion de Foreign Key
	@JoinColumn(name="nombreSala")
	private String nombreSala;	
	
	@ManyToOne
	@JoinColumn(name="idSalas")
	private Peliculas peliculas;

	//Constructores
	public Salas() {
		
	}

	/**
	 * 
	 * @param codigo
	 * @param nombreSala
	 * @param pelicula
	 */
	public Salas(Long codigo, String nombreSala, int pelicula, Peliculas peliculas) {
		this.codigo = codigo;
		this.nombreSala = nombreSala;
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
		return nombreSala;
	}

	/**
	 * 
	 * @param nombreSala
	 */
	public void setNombreSala(String nombreSala) {
		this.nombreSala = nombreSala;
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
		return "Salas [codigo=" + codigo + ", nombreSala=" + nombreSala + ", pelicula=" + pelicula + "]";
	}	
}
