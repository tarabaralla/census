package clast.census.mem.dao;

import clast.census.core.dao.AbstractUserRoleRelationDaoTest;
import clast.census.core.persistence.PersistenceManager;

public class HSqlUserRoleRelationDaoTest extends AbstractUserRoleRelationDaoTest {
	
	@Override
	public void configurePersistenceUnit() {
		PersistenceManager.setUpTestConnection("hsql_pu_test");
	}

}
