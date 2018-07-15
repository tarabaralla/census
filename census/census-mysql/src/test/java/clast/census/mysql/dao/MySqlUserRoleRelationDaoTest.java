package clast.census.mysql.dao;

import clast.census.core.dao.AbstractUserRoleRelationDaoTest;
import clast.census.core.persistence.PersistenceManager;

public abstract class MySqlUserRoleRelationDaoTest extends AbstractUserRoleRelationDaoTest {
	
	@Override
	public void configurePersistenceUnit() {
		PersistenceManager.setUpTestConnection("mysql_pu_test");
	}

}
