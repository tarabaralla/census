package clast.census.mysql.dao;

import clast.census.core.dao.AbstractUserRoleRelationDaoIT;
import clast.census.core.persistence.PersistenceManager;

public abstract class MySqlUserRoleRelationDaoIT extends AbstractUserRoleRelationDaoIT {
	
	@Override
	public void configurePersistenceUnit() {
		PersistenceManager.setUpTestConnection("mysql_pu_test");
	}

}
