package clast.census.mongo.dao;

import clast.census.core.dao.AbstractRoleDaoIT;
import clast.census.core.persistence.PersistenceManager;

public class MongoRoleDaoIT extends AbstractRoleDaoIT {
	
	@Override
	public void configurePersistenceUnit() {
		PersistenceManager.setUpTestConnection("mongo_pu_test");
	}

}