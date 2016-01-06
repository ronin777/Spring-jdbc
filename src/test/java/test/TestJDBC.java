package test;

import static org.junit.Assert.*;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:datasource-test.xml"})
public class TestJDBC {

	private static Log logger = LogFactory.getLog("TestJDBC");
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Test
	public void testJdbc(){
		logger.info("Iniciando test jdbc");
		
		int numPersona = jdbcTemplate.queryForInt("select count(*) from persona");
		logger.info("Numero de Personas : "+numPersona);
		
		assertEquals(2, numPersona);
		logger.info("Fin del test JDBC");
	}
	
}
