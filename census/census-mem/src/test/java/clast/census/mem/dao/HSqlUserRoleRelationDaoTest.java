package clast.census.mem.dao;

import clast.census.core.dao.AbstractUserRoleRelationDaoIT;
import clast.census.core.persistence.PersistenceManager;

public class HSqlUserRoleRelationDaoTest extends AbstractUserRoleRelationDaoIT {
	
	@Override
	public void configurePersistenceUnit() {
		PersistenceManager.setUpTestConnection("hsql_pu_test");
	}

}
