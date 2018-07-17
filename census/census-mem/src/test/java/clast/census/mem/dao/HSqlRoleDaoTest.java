package clast.census.mem.dao;

import clast.census.core.dao.AbstractRoleDaoIT;
import clast.census.core.persistence.PersistenceManager;
import clast.census.core.persistence.PersistenceType;

public class HSqlRoleDaoTest extends AbstractRoleDaoIT {
	
	@Override
	public void configurePersistenceUnit() {
		PersistenceManager.setUpTestConnection(PersistenceType.HSQL_TEST);
	}

}