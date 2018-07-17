package clast.census.mongo.dao;

import clast.census.core.dao.AbstractUserRoleRelationDaoIT;
import clast.census.core.persistence.PersistenceManager;
import clast.census.core.persistence.PersistenceType;

public class MongoUserRoleRelationDaoIT extends AbstractUserRoleRelationDaoIT {
	
	@Override
	public void configurePersistenceUnit() {
		PersistenceManager.setUpTestConnection(PersistenceType.MONGO_TEST);
	}

}
