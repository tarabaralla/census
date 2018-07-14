package clast.census.mem.dao;

import clast.census.core.dao.AbstractUserDaoTest;
import clast.census.core.persistence.PersistenceManager;

public class HSqlUserDaoTest extends AbstractUserDaoTest {
	
	@Override
	public void configurePersistenceUnit() {
		PersistenceManager.setUpTestConnection("hsql_pu_test");
	}

}