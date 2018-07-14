package clast.census.mongo.dao;

import clast.census.core.dao.AbstractRoleDaoTest;
import clast.census.core.persistence.PersistenceManager;

public class MongoRoleDaoTest extends AbstractRoleDaoTest {
	
	@Override
	public void configurePersistenceUnit() {
		PersistenceManager.setUpTestConnection("mongo_pu_test");
	}

}