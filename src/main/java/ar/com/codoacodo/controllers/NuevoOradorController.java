package ar.com.codoacodo.controllers;

import java.io.IOException;
import java.time.LocalDate;

import ar.com.codoacodo.entity.Orador;
import ar.com.codoacodo.repository.MySQLOradorRepository;
import ar.com.codoacodo.repository.OradorRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse; 

public class NuevoOradorController extends HttpServlet{
//envia por post todos los datos desde el formulario en el front
	
	protected void doPost(
			HttpServletRequest request, 
			HttpServletResponse response)
	throws ServletException, IOException {
	
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		String mail = request.getParameter("mail");
		String tema = request.getParameter("tema");
		
		//validar formato
		if(nombre == null || apellido == null || mail == null || tema == null) {
		//devuelve json de error
	}		
		
		OradorRepository repository = new MySQLOradorRepository();
		repository.save(new Orador(nombre, apellido, mail, tema, LocalDate.now()));
		//respondo al frontend con json ok
		
		System.out.println("ok");
	
	
	}
	
	
	

	
}
