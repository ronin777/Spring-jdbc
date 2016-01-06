package mx.com.ronin.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class PersonaRowMapper implements RowMapper<Persona> {

	public Persona mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Persona persona = new Persona();
		
		persona.setIdPersona(rs.getLong("id_persona"));
		persona.setNombre(rs.getString("nombre"));
		persona.setApePaterno(rs.getString("ape_paterno"));
		persona.setApeMaterno(rs.getString("ape_materno"));
		persona.setEmail(rs.getString("email"));
		
		return persona;
	}

}
