package clast.census.mongo.dao;

import clast.census.core.dao.AbstractSubRoleRelationDaoTest;
import clast.census.core.persistence.PersistenceManager;

public class MongoSubRoleRelationDaoTest extends AbstractSubRoleRelationDaoTest {
	
	@Override
	public void configurePersistenceUnit() {
		PersistenceManager.setUpTestConnection("mongo_pu_test");
	}

}