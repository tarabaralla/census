package clast.census.core.dao.mem;

import clast.census.core.dao.AbstractSubRoleRelationDaoTest;
import clast.census.core.persistence.EMFactoryImpl;
import clast.census.core.persistence.PersistenceManager;
import clast.census.core.persistence.PersistenceType;

public class HSqlSubRoleRelationDaoTest extends AbstractSubRoleRelationDaoTest {
	
	@Override
	public void configurePersistenceUnit() {
		PersistenceManager.setEmFactory(new EMFactoryImpl());
		PersistenceManager.setUpTestConnection(PersistenceType.HSQL_TEST);
	}

}