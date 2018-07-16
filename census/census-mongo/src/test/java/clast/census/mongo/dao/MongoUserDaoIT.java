package clast.census.mongo.dao;

import clast.census.core.dao.AbstractUserDaoIT;
import clast.census.core.persistence.PersistenceManager;

public class MongoUserDaoIT extends AbstractUserDaoIT {
	
	@Override
	public void configurePersistenceUnit() {
		PersistenceManager.setUpTestConnection("mongo_pu_test");
	}

}