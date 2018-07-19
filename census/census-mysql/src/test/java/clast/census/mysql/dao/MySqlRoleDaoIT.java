package clast.census.mysql.dao;

import clast.census.core.dao.AbstractRoleDaoTest;
import clast.census.core.persistence.EMFactoryImpl;
import clast.census.core.persistence.PersistenceManager;
import clast.census.core.persistence.PersistenceType;

public class MySqlRoleDaoIT extends AbstractRoleDaoTest {
	
	@Override
	public void configurePersistenceUnit() {
		PersistenceManager.setEmFactory(new EMFactoryImpl());
		PersistenceManager.setUpTestConnection(PersistenceType.MYSQL_TEST);
	}

}