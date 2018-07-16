package clast.census.mem.dao;

import clast.census.core.dao.AbstractSubRoleRelationDaoIT;
import clast.census.core.persistence.PersistenceManager;

public class HSqlSubRoleRelationDaoTest extends AbstractSubRoleRelationDaoIT {
	
	@Override
	public void configurePersistenceUnit() {
		PersistenceManager.setUpTestConnection("hsql_pu_test");
	}

}