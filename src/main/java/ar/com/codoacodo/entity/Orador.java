package ar.com.codoacodo.entity;

import java.time.LocalDate;

public class Orador {

	Long id;
	String nombre;
	String apellido;
	String mail;
	String tema;
	LocalDate fechaAlta;
	
	/*usado para enviar un orador a la DB*/
	
	public Orador(String nombre, String apellido, String mail, String tema, LocalDate fechaAlta) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.mail = mail;
		this.tema = tema;
		this.fechaAlta = fechaAlta;
	}
	/*cuando quera traer un orador desde la DB	 */

	public Orador(Long id, String nombre, String apellido, String mail, String tema, LocalDate fechaAlta) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.mail = mail;
		this.tema = tema;
		this.fechaAlta = fechaAlta;
	}
	
	/*getters y setters */
	public void setNombre(String nombre) {
		if(nombre != null) {
		this.nombre = nombre;
		
	}else {
		this.nombre = "n/d";
		
	}
	
	}
	public String getNombre() {
		return this.nombre;
				
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getTema() {
		return tema;
	}

	public void setTema(String tema) {
		this.tema = tema;
	}

	public LocalDate getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(LocalDate fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	@Override
	public String toString() {
		return "Orador [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", mail=" + mail + ", tema="
				+ tema + ", fechaAlta=" + fechaAlta + "]";
	}
	
}


