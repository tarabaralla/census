package clast.census.mongo.dao;

import clast.census.core.dao.AbstractUserDaoTest;
import clast.census.core.persistence.PersistenceManager;

public class MongoUserDaoTest extends AbstractUserDaoTest {
	
	@Override
	public void configurePersistenceUnit() {
		PersistenceManager.setUpTestConnection("mongo_pu_test");
	}

}