package clast.census.mem.dao;

import clast.census.core.dao.AbstractRoleDaoTest;
import clast.census.core.persistence.PersistenceManager;

public class HSqlRoleDaoTest extends AbstractRoleDaoTest {
	
	@Override
	public void configurePersistenceUnit() {
		PersistenceManager.setUpTestConnection("hsql_pu_test");
	}

}