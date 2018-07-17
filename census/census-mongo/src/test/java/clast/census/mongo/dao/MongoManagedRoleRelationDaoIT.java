package clast.census.mongo.dao;

import clast.census.core.dao.AbstractManagedRoleRelationDaoIT;
import clast.census.core.persistence.PersistenceManager;
import clast.census.core.persistence.PersistenceType;

public class MongoManagedRoleRelationDaoIT extends AbstractManagedRoleRelationDaoIT {
	
	@Override
	public void configurePersistenceUnit() {
		PersistenceManager.setUpTestConnection(PersistenceType.MONGO_TEST);
	}

}
