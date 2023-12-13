package ar.com.codoacodo.controllers;

import java.io.IOException;
import java.time.LocalDate;
import java.util.stream.Collectors;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import ar.com.codoacodo.entity.Orador;
import ar.com.codoacodo.repository.MySQLOradorRepository;
import ar.com.codoacodo.repository.OradorRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse; 
@WebServlet("/api/orador/nuevo")
public class NuevoOradorController extends HttpServlet{
//envia por post todos los datos desde el formulario en el front
	
	protected void doPost(
			HttpServletRequest request, 
			HttpServletResponse response)
	throws ServletException, IOException {
	//obtengo el json desde el frontend
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		String mail = request.getParameter("mail");
		String tema = request.getParameter("tema");
		
		String json = request.getReader()
				.lines()
				.collect(Collectors.joining(System.lineSeparator()));		
	//convierto de json string a objeto java usando libreria jacksoon2	
		ObjectMapper mapper = new ObjectMapper();
		mapper.registerModule(new JavaTimeModule());
		mapper.disable(SerializationFeature.WRITE_DATE_KEYS_AS_TIMESTAMPS);
		OradorRequest oradorRequest =mapper.readValue(json, OradorRequest.class);
	//manda a grabar en db	
		OradorRepository repository = new MySQLOradorRepository();
		Orador orador = new Orador(oradorRequest.getNombre(),
				oradorRequest.getApellido(),
				oradorRequest.getMail(),
				oradorRequest.getTema(),
				LocalDate.now());
		repository.save(orador);
	//convierte de objeto java a string
	//envia por medio de response al frontend
		response.getWriter().print(mapper.writeValueAsString(orador));

		
    }
}
