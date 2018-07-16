package clast.census.mysql.dao;

import clast.census.core.dao.AbstractSubRoleRelationDaoIT;
import clast.census.core.persistence.PersistenceManager;

public abstract class MySqlSubRoleRelationDaoIT extends AbstractSubRoleRelationDaoIT {
	
	@Override
	public void configurePersistenceUnit() {
		PersistenceManager.setUpTestConnection("mysql_pu_test");
	}

}