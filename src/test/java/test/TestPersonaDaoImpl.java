package test;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import mx.com.ronin.jdbc.Persona;
import mx.com.ronin.jdbc.PersonaDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:datasource-test.xml", "classpath:applicationContext.xml"})
public class TestPersonaDaoImpl {

	private static Log logger = LogFactory.getLog("TestPersonaDaoImpl");
	
	@Autowired
	private PersonaDao personaDao;
	
	@Test
	public void testMostrarListaPersonas(){
		try {
			System.out.println();
			logger.info("Iniciando test jdbc - Mostras lista personas");
			
			List<Persona> personas = personaDao.finAllPersonas();
			int contadorPersonas = 0;
			
			for (Persona persona : personas) {
				logger.info("Persona " +persona);
				contadorPersonas++;
			}
			
			assertEquals(contadorPersonas, personaDao.contadorPeronas());
			logger.info("Fin del test JDBC - Mostrar lista personas");
			
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("Error JDBC ",e);
		}
	
	}
	
}
