package clast.census.mysql.persistence;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import clast.census.core.persistence.EMFactoryImpl;
import clast.census.core.persistence.PersistenceManager;

public class MySqlPersistenceManagerIT {

	@Test
	public void testSetUpMySqlConnection() {
		
		PersistenceManager.tearDownDbConnection();
		
		assertNull(PersistenceManager.getEntityManager());
		
		PersistenceManager.setEmFactory(new EMFactoryImpl());
		PersistenceManager.setUpMySQLConnection("jdbc:mysql://localhost:3307/censusdb?createDatabaseIfNotExist=true", "root", "root");
		
		assertNotNull(PersistenceManager.getEntityManager());
		
		PersistenceManager.tearDownDbConnection();
		
		assertNull(PersistenceManager.getEntityManager());
		
	}

}
