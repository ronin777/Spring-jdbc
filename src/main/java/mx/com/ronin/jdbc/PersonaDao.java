package mx.com.ronin.jdbc;

import java.util.List;

public interface PersonaDao {

	public void insertPersona(Persona persona);

	public void updatePersona(Persona persona);

	public void deletePersona(Persona persona);

	public Persona findPersonaById(int idPersona);

	public List<Persona> finAllPersonas();

	public int contadorPersonasPorNombre(Persona persona);

	public int contadorPeronas();

	public Persona getPersonaByEmail(Persona persona);

}
