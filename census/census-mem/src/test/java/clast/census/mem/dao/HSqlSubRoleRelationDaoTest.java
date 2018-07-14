package clast.census.mem.dao;

import clast.census.core.dao.AbstractSubRoleRelationDaoTest;
import clast.census.core.persistence.PersistenceManager;

public class HSqlSubRoleRelationDaoTest extends AbstractSubRoleRelationDaoTest {
	
	@Override
	public void configurePersistenceUnit() {
		PersistenceManager.setUpTestConnection("hsql_pu_test");
	}

}