package clast.census.mysql.dao;

import clast.census.core.dao.AbstractManagedRoleRelationDaoIT;
import clast.census.core.persistence.PersistenceManager;

public abstract class MySqlManagedRoleRelationDaoIT extends AbstractManagedRoleRelationDaoIT {
	
	@Override
	public void configurePersistenceUnit() {
		PersistenceManager.setUpTestConnection("mysql_pu_test");
	}

}
