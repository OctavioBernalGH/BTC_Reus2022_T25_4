package dto;

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
	private int codigo;
	@Column (name="pelicula")
	private int pelicula;
	@ManyToOne // Creamos una relacion de Foreign Key
	@JoinColumn(name="nombreSala")
	private String nombreSala;	

	//Constructores
	public Salas() {
		
	}

	/**
	 * 
	 * @param codigo
	 * @param nombreSala
	 * @param pelicula
	 */
	public Salas(int codigo, String nombreSala, int pelicula) {
		this.codigo = codigo;
		this.nombreSala = nombreSala;
		this.pelicula = pelicula;
	}

	// Getters y setters
	/**
	 * 
	 * @return de codigo
	 */
	public int getCodigo() {
		return codigo;
	}

	/**
	 * 
	 * @param codigo
	 */
	public void setCodigo(int codigo) {
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

	@Override
	public String toString() {
		return "Salas [codigo=" + codigo + ", nombreSala=" + nombreSala + ", pelicula=" + pelicula + "]";
	}	
}
