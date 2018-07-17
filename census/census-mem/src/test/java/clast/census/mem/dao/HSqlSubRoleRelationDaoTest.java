package clast.census.mem.dao;

import clast.census.core.dao.AbstractSubRoleRelationDaoIT;
import clast.census.core.persistence.PersistenceManager;
import clast.census.core.persistence.PersistenceType;

public class HSqlSubRoleRelationDaoTest extends AbstractSubRoleRelationDaoIT {
	
	@Override
	public void configurePersistenceUnit() {
		PersistenceManager.setUpTestConnection(PersistenceType.HSQL_TEST);
	}

}