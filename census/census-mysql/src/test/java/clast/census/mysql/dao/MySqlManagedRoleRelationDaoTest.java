package clast.census.mysql.dao;

import clast.census.core.dao.AbstractManagedRoleRelationDaoTest;
import clast.census.core.persistence.PersistenceManager;

public abstract class MySqlManagedRoleRelationDaoTest extends AbstractManagedRoleRelationDaoTest {
	
	@Override
	public void configurePersistenceUnit() {
		PersistenceManager.setUpTestConnection("mysql_pu_test");
	}

}
