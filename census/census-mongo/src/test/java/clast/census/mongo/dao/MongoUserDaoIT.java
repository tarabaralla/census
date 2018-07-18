package clast.census.mongo.dao;

import clast.census.core.dao.AbstractUserDaoTest;
import clast.census.core.persistence.PersistenceManager;
import clast.census.core.persistence.PersistenceType;

public class MongoUserDaoIT extends AbstractUserDaoTest {
	
	@Override
	public void configurePersistenceUnit() {
		PersistenceManager.setUpTestConnection(PersistenceType.MONGO_TEST);
	}

}