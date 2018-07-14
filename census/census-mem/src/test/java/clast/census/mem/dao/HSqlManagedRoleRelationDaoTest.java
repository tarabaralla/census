package clast.census.mem.dao;

import clast.census.core.dao.AbstractManagedRoleRelationDaoTest;
import clast.census.core.persistence.PersistenceManager;

public class HSqlManagedRoleRelationDaoTest extends AbstractManagedRoleRelationDaoTest {
	
	@Override
	public void configurePersistenceUnit() {
		PersistenceManager.setUpTestConnection("hsql_pu_test");
	}

}

