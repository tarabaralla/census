package clast.census.mongo.dao;

import clast.census.core.dao.AbstractManagedRoleRelationDaoIT;
import clast.census.core.persistence.PersistenceManager;

public class MongoManagedRoleRelationDaoIT extends AbstractManagedRoleRelationDaoIT {
	
	@Override
	public void configurePersistenceUnit() {
		PersistenceManager.setUpTestConnection("mongo_pu_test");
	}

}
