package ar.com.codoacodo.repository;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.List;

import ar.com.codoacodo.entity.Orador;

public class MySQLOradorRepository implements OradorRepository {

	@Override
	public void save(Orador orador) {
		String sql = "insert into orador (nombre,apellido,mail,tema,fecha_alta) values (?,?,?,?,?)";
		Connection conn = AdministradorDeConexiones.getConnection();
		try {
			PreparedStatement statement = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
			statement.setString(1, orador.getNombre());
			statement.setString(2, orador.getApellido());
			statement.setString(3, orador.getMail());
			statement.setString(4, orador.getTema());
			statement.setDate(5, new java.sql.Date(System.currentTimeMillis()));
			
			statement.executeUpdate();
		}catch (Exception e) {
			throw new IllegalArgumentException("No se pudo crear el orador",e);
		}
	}

	@Override
	public Orador getById(Long id) {
		
		String sql = "select id, nombre, apellido, email, tema, fecha_alta from orador where id = ?";
		Connection conn = AdministradorDeConexiones.getConnection();
		
		Orador orador = null;
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			
			statement.setLong(1, id);
			
			ResultSet res = statement.executeQuery();
			
			if(res.next()) {
				
				Long _id = res.getLong(1);
				String nombre = res.getString(2);
				String apellido = res.getString(3);
				String email = res.getString(4);
				String tema = res.getString(5);
				Date fechaAlta = res.getDate(6);
				
				return new Orador(id,nombre, apellido, email, tema, LocalDate.now() );
				
			}
		}catch (Exception e) {
			throw new IllegalArgumentException("No se pudo obtener el orador.",e);
			
		}
		return orador;
		
	}

	@Override
	public void update(Orador orador) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Orador> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}

     