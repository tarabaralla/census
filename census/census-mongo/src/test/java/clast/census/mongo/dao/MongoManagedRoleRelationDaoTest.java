package clast.census.mongo.dao;

import clast.census.core.dao.AbstractManagedRoleRelationDaoTest;
import clast.census.core.persistence.PersistenceManager;

public class MongoManagedRoleRelationDaoTest extends AbstractManagedRoleRelationDaoTest {
	
	@Override
	public void configurePersistenceUnit() {
		PersistenceManager.setUpTestConnection("mongo_pu_test");
	}

}
