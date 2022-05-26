<table>
<tr>
<td width="100px"><img src="https://user-images.githubusercontent.com/103035621/170483040-a88d598b-145b-4903-accb-948ceff05811.png" alt="Team DOU"/></td>
<td width="1100px"> <h2>MSKA: Spring + JPA + MYSQL UD25_Ejercicio-4</h2> </td>

</tr>
</table>

[![Java](https://img.shields.io/badge/Java-FrontEnd-informational)]()
[![JBuilder](https://img.shields.io/badge/JBuilder-View-critical)]()
[![JUnit 5](https://img.shields.io/badge/JUnit%205-Testing-success)]()
[![GitHub](https://img.shields.io/badge/GitHub-Repository-lightgrey)]()
[![SQL](https://img.shields.io/badge/SQL-DataBase-yellowgreen)]()
[![Spring](https://img.shields.io/badge/Spring-infrastructure-brightgreen)]()
[![Maven](https://img.shields.io/badge/Maven-ProjectStructure-blueviolet)]()

Este ejercicio ha sido realizado por los miembros del equipo 1. Dicho equipo esta formado por:

  [- Ixabel Justo Etxeberria](https://github.com/Kay-Nicte)<br>
  [- J.Oriol López Bosch](https://github.com/mednologic)<br>
  [- Octavio Bernal](https://github.com/OctavioBernalGH)<br>
  [- David Dalmau](https://github.com/DavidDalmauDieguez)

<p align="justify">Se crea un proyecto Maven utilizando la tecnología spring, se definen como componentes los spring services, la base de datos H2 y JPA. Se crea la estructura de proyecto en capas definiendo los paquetes de controllers, dao, dto y services. Para proseguir se crean las entidades 'peliculas' y 'salas' con una relación de uno a muchos (one to many). Se definen las columnas y mediante anotaciones se mapea con los atributos de la entidad.</p>

<p align="justify">Antes de proceder con la creación de paquetes y estructuras se definirán los parámetros de acceso a la base de datos H2, para ello se añaden las siguiente línas en el fichero 'application.propierties' ubicado en 'src/main/resources/.</p>

<p align="center">
  <img src="https://user-images.githubusercontent.com/103035621/169650442-7c57e6ec-69cd-42de-a819-2d1a3c47fee4.png">
</p>

<p align="justify">A vez este definido el application.propierties se procederá a la creación de la estructura de proyecto, en este caso queda tal que así:</p>

<p align="center">
    <img src="https://user-images.githubusercontent.com/103035621/169659750-9cb1ab87-11f8-4640-a94d-0130d08789e5.png">
</p>

Para comenzar con el código Java spring se deberán crear las entidades 'peliculas' y 'salas' en el paquete DTO. En estas entidades se mapearán los atributos de clase con columnas en base de datos, de esta forma se realizará el CRUD java aplicado a la BBDD.

```java
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

```
Se deberá realizar el mismo procedimiento con la entidad 'salas' , hay que tener en cuanta las anotaciones introducidas en ambas clases, a continuación se muestra el código de la clase 'salas':

```java
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

```

Una vez esté todo correcto se proseguirá con el DAO. Se crearán dos interfaces DAO que extenderán de la clase JpaRepository para acceder a los métodos CRUD básicos de Jpa para atacar a la base de datos. De esta forma se ahorra mucho código.

```java
package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.dto.Peliculas;

// Repositorio de funcion es de base de datos
@Repository
public interface PeliculasDAO extends JpaRepository<Peliculas,Long>{
	
}
```
Se seguirá el mismo proceso con el otro fichero DAO llamado Salas.DAO:

```java
package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.dto.Salas;

@Repository
public interface SalasDAO extends JpaRepository<Salas,Long>{

}
```

A continuación se creará la interfaz 'PeliculaService' donde se definirán las cabeceras de las funciones CRUD:

```java
package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.Peliculas;

public interface PeliculaService {
	public List<Peliculas> listarPeliculas();

	public Peliculas crearPeliculas(Peliculas pelicula);

	public Peliculas modificarPeliculas(Peliculas pelicula);

	public void eliminarPeliculas(Long codigo);

	public Peliculas buscarPeliculas(Long codigo);

}
```

Se realizará el mismo procedimiento en la interfaz 'SalasService':

```java
package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.Salas;

public interface SalasService {
	public List<Salas> listarSalas();

	public Salas crearSalas(Salas sala);

	public Salas modificarSalas(Salas sala);

	public void eliminarSalas(Long codigo);

	public Salas buscarSalas(Long codigo);
}
```
A continuación se crearán dos clases de la capa service llamadas 'PeliculasServiceImpl' y 'SalasServiceImpl' las cuales implementarán las interfaces correspondientes para desarrollar el tipo de retorno de las funciones definidas.

```java
package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.dao.PeliculasDAO;
import com.example.demo.dto.Peliculas;

@Service
public class PeliculaServiceImpl implements PeliculaService {

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

```

Se realizará el mismo procedimiento en la clase 'SalasServiceImpl':

```java
package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.dao.SalasDAO;
import com.example.demo.dto.Salas;

@Service
public class SalasServiceImpl implements SalasService{

	// Utilizar metodos DAO heredados de JPA
	@Autowired
	SalasDAO salasDao;

	@Override
	public List<Salas> listarSalas() {
		return salasDao.findAll();
	}

	@Override
	public Salas crearSalas(Salas sala) {
		return salasDao.save(sala);
	}

	@Override
	public Salas modificarSalas(Salas sala) {
		return salasDao.save(sala);
	}

	@Override
	public void eliminarSalas(Long codigo) {
		salasDao.deleteById(codigo);
	}

	@Override
	public Salas buscarSalas(Long codigo) {
		return salasDao.findById(codigo).get();
	}

}

``` 

Por último se crearán los controladores correspondientes, en este caso sería 'PeliculasController' y 'SalasController'. En ambas se utilizarán las anotaciones @RestController y @RequestMapping("/direccionApi") con los diferentes métodos HTTP definidos. El siguiente fragmento de código corresponde al controlador de la clase Peliculas:

```java
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

import com.example.demo.dto.Peliculas;
import com.example.demo.service.PeliculaServiceImpl;

@RestController
@RequestMapping("/api") //Raiz de la app
public class PeliculaController {
	@Autowired
	PeliculaServiceImpl peliculaServiceImpl;
	
	// Listar todas las salas
	@GetMapping("/peliculas")
	public List<Peliculas> listarPeliculas(){
		return peliculaServiceImpl.listarPeliculas();
	}
	
	// Buscar las salas por id
	@GetMapping("/peliculas/{id}")
	public Peliculas buscarSalaCodigo(@PathVariable(name= "id")Long codigo) {
		return peliculaServiceImpl.buscarPeliculas(codigo);		
	}
	
	// Eliminar una sala
	@DeleteMapping("/peliculas/{id}")
	public void eliminarSalas(@PathVariable(name="id")Long codigo) {
		peliculaServiceImpl.eliminarPeliculas(codigo);
	}
	
	// Crear sala
	@PostMapping("/peliculas")
	public Peliculas crearPeliculas(@RequestBody Peliculas peliculas) {
		return peliculaServiceImpl.crearPeliculas(peliculas);
	}
	
	// Modificar sala
	@PutMapping("/peliculas/{id}")
	public Peliculas modificarPeliculas (@PathVariable(name="id")Long codigo, @RequestBody Peliculas peliculas) {
		Peliculas pelicula_a_modificar = new Peliculas();
		Peliculas modificado = new Peliculas();
		
		// Busco el id de la sala que quiero cambiar
		pelicula_a_modificar = peliculaServiceImpl.buscarPeliculas(codigo);
		
		pelicula_a_modificar.setCodigo(peliculas.getCodigo());
		pelicula_a_modificar.setNombre(peliculas.getNombre());
		pelicula_a_modificar.setCalificacionEdad(peliculas.getCalificacionEdad());
		
		// Modificado es = a los cambios aplicados
		modificado = peliculaServiceImpl.modificarPeliculas(pelicula_a_modificar);
		
		return modificado;
		
	}
}

```

Se realizará el mismo procedimiento en la clase 'SalasController':

```java
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

```

A continuación se creará un fichero "data.sql" en la carpeta resources en el cual irá ubicado el código referentes a la creación de tablas utilizadas y los inserts en las diferentes tablas para poder comprobar su funcionamiento en postman. Para ello se introduce el siguiente código SQL:

```sql

CREATE TABLE `peliculas` (
    `codigo` INT,
    `nombre_pelicula` VARCHAR(100),
    `calificacion_edad` INT,
    PRIMARY KEY (`codigo`)
);

CREATE TABLE `salas` (
    `codigo` INT,
    `pelicula` INT,
    `nombre_sala` VARCHAR(100),
    `id_peliculas` INT,
    PRIMARY KEY (`codigo`),
    FOREIGN KEY (`id_peliculas`)
        REFERENCES `peliculas` (`codigo`)
);

insert into `peliculas`(`codigo`,`nombre_pelicula`, `calificacion_edad`) values (1,'Harry popotter', 1);
insert into `peliculas`(`codigo`,`nombre_pelicula`, `calificacion_edad`) values (2,'La momia', 2);
insert into `peliculas`(`codigo`,`nombre_pelicula`, `calificacion_edad`) values (3,'Star guarros', 3);
insert into `peliculas`(`codigo`,`nombre_pelicula`, `calificacion_edad`) values (4,'Alvin y las ardillas', 4);
insert into `peliculas`(`codigo`,`nombre_pelicula`, `calificacion_edad`) values (5,'El señor de los martillos', 5);

insert into `salas`(`codigo`,`pelicula`, `nombre_sala`, `id_peliculas`)values(1,1,'Sala 1',1);
insert into `salas`(`codigo`,`pelicula`, `nombre_sala`, `id_peliculas`)values(2,2,'Sala 2',2);
insert into `salas`(`codigo`,`pelicula`, `nombre_sala`, `id_peliculas`)values(3,3,'Sala 3',3);
insert into `salas`(`codigo`,`pelicula`, `nombre_sala`, `id_peliculas`)values(4,4,'Sala 4',4);
insert into `salas`(`codigo`,`pelicula`, `nombre_sala`, `id_peliculas`)values(5,5,'Sala 5',5);
```

Ahora se verificará el funcionamiento del aplicativo Spring mediante la aplicación postman. Esta aplicación nos permite enviar distintas peticiones a un servidor enviando por parámetros y body lo necesario para un correcto funcionamiento de la api.

El primero de todos los métodos HTTP utilizados es el GET. Para ello se inicia postman y se ejecuta este método con la siguiente dirección a la api:

<p align="center">
	<img src="https://user-images.githubusercontent.com/103035621/169661166-5a0b10a9-0022-4147-b4a9-3b1c645545c3.PNG">
</p>

En la anterior imagen y la siguiente se puede observar el listado de peliculas y salas mediante el método GET y con sus respectivas rutas en la api.

<p align="center">
	<img src="https://user-images.githubusercontent.com/103035621/169661178-6b7760e0-69d6-4e73-bcf0-4061cdf070bf.PNG">
</p>

En la siguiente imagen se puede observar una pelicula filtrada por su identificador.

<p align="center">
	<img src="https://user-images.githubusercontent.com/103035621/169661198-ea9c487c-dac6-4d3f-b5b3-047b5b895ef9.PNG">
</p>

A continuación se filtran las salas mediante un identificador de salas.

<p align="center">
	<img src="https://user-images.githubusercontent.com/103035621/169661254-45bdfcda-450e-4c2f-99cd-1f8162baabe8.PNG">
</p>

A continuación se muestra la eliminación de una sala relacionada con una pelicula:

<p align="center">
	<img src="https://user-images.githubusercontent.com/103035621/169661434-af78e054-52ca-4dff-860e-93040e2763e6.PNG">
</p>

Se realiza el mismo ejemplo al eliminar una única sala:

<p align="center">
	<img src="https://user-images.githubusercontent.com/103035621/169661446-9d266306-6860-46b1-9b5e-eb6bef002e78.PNG">
</p>

En la siguiente captura se creará una sala:

<p align="center">
	<img src="https://user-images.githubusercontent.com/103035621/169661524-0d8f37fe-2580-4457-9eb4-e0b19a44cbd2.PNG">
</p>

En la siguiente captura se modificará una sala:

<p align="center">
	<img src="https://user-images.githubusercontent.com/103035621/169661563-c525ebc1-5ee8-44e7-b7c0-3fad678829f2.PNG">
</p>

Para finalizar, una conclusión, es muy importante fijarse en las anotaciones, una anotación sin poner puede afectar en el flujo del programa impidiendo el funcionamiento del aplicativo.
