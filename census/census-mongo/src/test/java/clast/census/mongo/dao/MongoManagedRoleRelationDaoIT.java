package clast.census.mongo.dao;

import clast.census.core.dao.AbstractManagedRoleRelationDaoTest;
import clast.census.core.persistence.EMFactoryImpl;
import clast.census.core.persistence.PersistenceManager;
import clast.census.core.persistence.PersistenceType;

public class MongoManagedRoleRelationDaoIT extends AbstractManagedRoleRelationDaoTest {
	
	@Override
	public void configurePersistenceUnit() {
		PersistenceManager.setEmFactory(new EMFactoryImpl());
		PersistenceManager.setUpTestConnection(PersistenceType.MONGO_TEST);
	}

}
