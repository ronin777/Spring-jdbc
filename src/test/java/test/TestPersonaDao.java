package test;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import mx.com.ronin.jdbc.Persona;
import mx.com.ronin.jdbc.PersonaDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:datasource-test.xml", "classpath:applicationContext.xml" })
public class TestPersonaDao {

	private static Log logger = LogFactory.getLog("TestPersonaDaoImpl");

	@Autowired
	private PersonaDao personaDao;

	@Test
	@Ignore //comentar sino se ejecutar esta prueba
	public void testMostrarListaPersonas() {
		try {
			System.out.println();
			logger.info("Iniciando test jdbc - Mostras lista personas");

			List<Persona> personas = personaDao.finAllPersonas();
			int contadorPersonas = 0;

			for (Persona persona : personas) {
				logger.info("Persona " + persona);
				contadorPersonas++;
			}

			assertEquals(contadorPersonas, personaDao.contadorPeronas());
			logger.info("Fin del test JDBC - Mostrar lista personas");

		} catch (Exception e) {
			// TODO: handle exception
			logger.error("Error JDBC ", e);
		}

	}

	@Test
	public void testContadorPorNombre(){
		try {
			System.out.println();
			logger.info("Inicio de test contador personas por nombre");
			String nombre = "admin";
			Persona personaEjemplo = new Persona();
			personaEjemplo.setNombre(nombre);
			int numPersonasEncontradas = personaDao.contadorPersonasPorNombre(personaEjemplo);
			logger.info("Numero de personas encontradas por nombre : "+nombre+" son "+numPersonasEncontradas);
			assertEquals(1, numPersonasEncontradas);
			logger.info("Fin del test contador por persona ");
			
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("Error jdbc", e);
		}
	}
	
	@Test
	public void testEncontrarPersonaPorID(){
		try {
			System.out.println();
			logger.info("Inicio de test encontrar personas por ID");
			int idPersona = 1;
			Persona persona = personaDao.findPersonaById(idPersona);
			assertEquals("admin", persona.getNombre());
			logger.info("Persona recuperada ID: "+idPersona+" > "+persona);
			logger.info("Fin del test encontrar Persona por ID");
			
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("Error jdbc", e);
		}
	}
	

}
