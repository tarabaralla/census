package clast.census.mysql.dao;

import clast.census.core.dao.AbstractUserDaoIT;
import clast.census.core.persistence.PersistenceManager;

public abstract class MySqlUserDaoIT extends AbstractUserDaoIT {
	
	@Override
	public void configurePersistenceUnit() {
		PersistenceManager.setUpTestConnection("mysql_pu_test");
	}

}