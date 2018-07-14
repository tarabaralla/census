package clast.census.mongo.dao;

import clast.census.core.dao.AbstractUserRoleRelationDaoTest;
import clast.census.core.persistence.PersistenceManager;

public class MongoUserRoleRelationDaoTest extends AbstractUserRoleRelationDaoTest {
	
	@Override
	public void configurePersistenceUnit() {
		PersistenceManager.setUpTestConnection("mongo_pu_test");
	}

}
