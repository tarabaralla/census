package clast.census.mem.dao;

import clast.census.core.dao.AbstractUserDaoIT;
import clast.census.core.persistence.PersistenceManager;

public class HSqlUserDaoTest extends AbstractUserDaoIT {
	
	@Override
	public void configurePersistenceUnit() {
		PersistenceManager.setUpTestConnection("hsql_pu_test");
	}

}