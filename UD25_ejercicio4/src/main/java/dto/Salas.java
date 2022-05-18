package dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="salas")// En caso que la tabla sea diferente
public class Salas {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//busca ultimo valor y lo incrementa
	private int codigo;
	
}
