package clast.census.mongo.persistence;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import clast.census.core.persistence.EMFactoryImpl;
import clast.census.core.persistence.PersistenceManager;

public class MongoPersistenceManagerIT {

	@Test
	public void testSetUpMongoConnection() {
		
		PersistenceManager.tearDownDbConnection();
		
		assertNull(PersistenceManager.getEntityManager());
		
		PersistenceManager.setEmFactory(new EMFactoryImpl());
		PersistenceManager.setUpMongoConnection("localhost", "27017", "censusDB");
		
		assertNotNull(PersistenceManager.getEntityManager());
		
		PersistenceManager.tearDownDbConnection();
		
		assertNull(PersistenceManager.getEntityManager());
		
	}

}
