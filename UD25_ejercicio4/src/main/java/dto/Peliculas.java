package dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="peliculas")// En caso que la tabla sea diferente
public class Peliculas {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//busca ultimo valor y lo incrementa
	private int codigo;
	@Column(name="nombrePelicula")
	private String nombrePelicula;
	@Column(name="CalificacionEdad")
	private int CalificacionEdad;
	
	//Constructores
	public Peliculas() {
		
	}

	/**
	 * 
	 * @param codigo
	 * @param nombrePelicula
	 * @param calificacionEdad
	 */
	public Peliculas(int codigo, String nombrePelicula, int calificacionEdad) {
		this.codigo = codigo;
		this.nombrePelicula = nombrePelicula;
		CalificacionEdad = calificacionEdad;
	}
	
	// Getters y setters
	/**
	 * 
	 * @return de id
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
}
