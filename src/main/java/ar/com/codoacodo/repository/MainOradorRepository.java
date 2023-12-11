package ar.com.codoacodo.repository;

import java.time.LocalDate;
import java.util.List;

import ar.com.codoacodo.entity.Orador;

public class MainOradorRepository {
	
	public static void main(String[] args) {
	
		
		OradorRepository repository = new MySQLOradorRepository();
		
	//	Orador orador = repository.getById(1L);
		
		//cambios
	//	orador.setId(null);
	//	orador.setMail("otromail@mail.com");
	//	System.out.println(orador);
		
	//repository.delete(2L);
	//Orador o = repository.getById(1L);
	//o.setNombre("Juan Jose");
	//o.setApellido("Perez");
	//o.setTema("php");
	//o.setMail(o.getMail());
	
	//repository.update(o);
	//o = repository.getById(null);
	//para probar el findAll
		Orador nuevo = new Orador("Maria", "Rojas", "mrojas@mail.com","c#", LocalDate.now());
		repository.save(nuevo);
		
		List<Orador> oradores = repository.findAll();
		
	System.out.println(oradores);
	
	}

}