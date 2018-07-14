package clast.census.mysql.dao;

import clast.census.core.dao.AbstractUserDaoTest;
import clast.census.core.persistence.PersistenceManager;

public class MySqlUserDaoTest extends AbstractUserDaoTest {
	
	@Override
	public void configurePersistenceUnit() {
		PersistenceManager.setUpTestConnection("mysql_pu_test");
	}

}