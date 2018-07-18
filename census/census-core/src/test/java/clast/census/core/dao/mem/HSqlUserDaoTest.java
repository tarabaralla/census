package clast.census.core.dao.mem;

import clast.census.core.dao.AbstractUserDaoTest;
import clast.census.core.persistence.PersistenceManager;
import clast.census.core.persistence.PersistenceType;

public class HSqlUserDaoTest extends AbstractUserDaoTest {
	
	@Override
	public void configurePersistenceUnit() {
		PersistenceManager.setUpTestConnection(PersistenceType.HSQL_TEST);
	}

}