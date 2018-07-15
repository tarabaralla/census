package clast.census.mysql.dao;

import clast.census.core.dao.AbstractRoleDaoTest;
import clast.census.core.persistence.PersistenceManager;

public abstract class MySqlRoleDaoTest extends AbstractRoleDaoTest {
	
	@Override
	public void configurePersistenceUnit() {
		PersistenceManager.setUpTestConnection("mysql_pu_test");
	}

}