package clast.census.mongo.dao;

import clast.census.core.dao.AbstractSubRoleRelationDaoIT;
import clast.census.core.persistence.PersistenceManager;

public class MongoSubRoleRelationDaoIT extends AbstractSubRoleRelationDaoIT {
	
	@Override
	public void configurePersistenceUnit() {
		PersistenceManager.setUpTestConnection("mongo_pu_test");
	}

}