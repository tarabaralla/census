package clast.census.mem.dao;

import clast.census.core.dao.AbstractRoleDaoIT;
import clast.census.core.persistence.PersistenceManager;

public class HSqlRoleDaoTest extends AbstractRoleDaoIT {
	
	@Override
	public void configurePersistenceUnit() {
		PersistenceManager.setUpTestConnection("hsql_pu_test");
	}

}