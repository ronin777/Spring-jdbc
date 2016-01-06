package mx.com.ronin.jdbc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import sun.jdbc.odbc.ee.DataSource;

@Repository
public class PersonaDaoImpl implements PersonaDao {

	 private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	 private JdbcTemplate jdbcTemplate;
	
	 @Autowired
	 public void setDataSource(DataSource dataSource){
		 this.jdbcTemplate = new JdbcTemplate(dataSource);
		 this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	 }
	 
	 private static final String SQL_INSERT_PERSONA="INSERT INTO PERSONA (nombre, ape_paterno, ape_materno, email) values (:nombre, :apePaterno, :apeMaterno, :email)";
	 private static final String SQL_UPDATE_PERSONA="UPDATE PERSONA set nombre = :nombre, ape_paterno = :apePaterno, ape_materno = :apeMaterno, email = :email WHERE id_persona = :idPersona";
	 private static final String SQL_DELETE_PERSONA="DELETE FROM PERSONA WHERE id_persona = :idPersona";
	 private static final String SQL_SELECT_PERSONA="SELECT id_persona, nombre, ape_paterno, ape_materno, email FROM PERSONA";
	 private static final String SQL_SELECT_PERSONA_BY_ID=SQL_SELECT_PERSONA+" WHERE id_persona = ?";
	 
	public void insertPersona(Persona persona) {
		// TODO Auto-generated method stub
		
	}

	public void updatePersona(Persona persona) {
		// TODO Auto-generated method stub

	}

	public void deletePersona(Persona persona) {
		// TODO Auto-generated method stub

	}

	public Persona findPersonaById(int idPersona) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Persona> finAllPersonas() {
		// TODO Auto-generated method stub
		RowMapper<Persona> personaRowMapper = ParameterizedBeanPropertyRowMapper.newInstance(Persona.class);
		return this.jdbcTemplate.query(SQL_SELECT_PERSONA_BY_ID, personaRowMapper);
	}

	public int contadorPersonasPorNombre(Persona persona) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int contadorPeronas() {
		// TODO Auto-generated method stub
		String sql = "SELECT count(*) FROM PERSONA";
		return this.jdbcTemplate.queryForInt(sql);
	}

	public Persona getPersonaByEmail(Persona persona) {
		// TODO Auto-generated method stub
		return null;
	}

}
