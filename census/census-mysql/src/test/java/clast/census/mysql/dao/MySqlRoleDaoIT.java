package clast.census.mysql.dao;

import clast.census.core.dao.AbstractRoleDaoIT;
import clast.census.core.persistence.PersistenceManager;

public abstract class MySqlRoleDaoIT extends AbstractRoleDaoIT {
	
	@Override
	public void configurePersistenceUnit() {
		PersistenceManager.setUpTestConnection("mysql_pu_test");
	}

}