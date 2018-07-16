package clast.census.mongo.dao;

import clast.census.core.dao.AbstractUserRoleRelationDaoIT;
import clast.census.core.persistence.PersistenceManager;

public class MongoUserRoleRelationDaoIT extends AbstractUserRoleRelationDaoIT {
	
	@Override
	public void configurePersistenceUnit() {
		PersistenceManager.setUpTestConnection("mongo_pu_test");
	}

}
