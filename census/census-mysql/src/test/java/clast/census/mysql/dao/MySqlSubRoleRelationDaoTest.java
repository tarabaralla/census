package clast.census.mysql.dao;

import clast.census.core.dao.AbstractSubRoleRelationDaoTest;
import clast.census.core.persistence.PersistenceManager;

public class MySqlSubRoleRelationDaoTest extends AbstractSubRoleRelationDaoTest {
	
	@Override
	public void configurePersistenceUnit() {
		PersistenceManager.setUpTestConnection("mysql_pu_test");
	}

}