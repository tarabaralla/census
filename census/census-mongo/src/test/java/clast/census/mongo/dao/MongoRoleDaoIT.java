package clast.census.mongo.dao;

import clast.census.core.dao.AbstractRoleDaoTest;
import clast.census.core.persistence.PersistenceManager;
import clast.census.core.persistence.PersistenceType;

public class MongoRoleDaoIT extends AbstractRoleDaoTest {
	
	@Override
	public void configurePersistenceUnit() {
		PersistenceManager.setUpTestConnection(PersistenceType.MONGO_TEST);
	}

}