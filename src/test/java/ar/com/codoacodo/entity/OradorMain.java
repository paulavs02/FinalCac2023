package ar.com.codoacodo.entity;

import java.time.LocalDate;

public class OradorMain {

	public static void main(String[] args) {
		
		Orador nuevoOrador =new Orador("Paula","Soria","paula@mailcito.com","codoacodo", LocalDate.now());
		
		System.out.println(nuevoOrador);

		Orador nuevoFromDB = new Orador (1L,"Paula","Soria","paula@mailcito.com","codoacodo", LocalDate.now());
		
		nuevoOrador.setNombre("Pipo");
			
		
	}

}
