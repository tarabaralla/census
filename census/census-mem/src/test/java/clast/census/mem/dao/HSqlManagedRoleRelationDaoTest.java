package clast.census.mem.dao;

import clast.census.core.dao.AbstractManagedRoleRelationDaoIT;
import clast.census.core.persistence.PersistenceManager;

public class HSqlManagedRoleRelationDaoTest extends AbstractManagedRoleRelationDaoIT {
	
	@Override
	public void configurePersistenceUnit() {
		PersistenceManager.setUpTestConnection("hsql_pu_test");
	}

}

