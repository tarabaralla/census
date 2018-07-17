package clast.census.mongo.dao;

import clast.census.core.dao.AbstractSubRoleRelationDaoIT;
import clast.census.core.persistence.PersistenceManager;
import clast.census.core.persistence.PersistenceType;

public class MongoSubRoleRelationDaoIT extends AbstractSubRoleRelationDaoIT {
	
	@Override
	public void configurePersistenceUnit() {
		PersistenceManager.setUpTestConnection(PersistenceType.MONGO_TEST);
	}

}