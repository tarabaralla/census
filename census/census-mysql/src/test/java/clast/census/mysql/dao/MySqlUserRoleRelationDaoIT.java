package clast.census.mysql.dao;

import clast.census.core.dao.AbstractUserRoleRelationDaoTest;
import clast.census.core.persistence.EMFactoryImpl;
import clast.census.core.persistence.PersistenceManager;
import clast.census.core.persistence.PersistenceType;

public class MySqlUserRoleRelationDaoIT extends AbstractUserRoleRelationDaoTest {
	
	@Override
	public void configurePersistenceUnit() {
		PersistenceManager.setEmFactory(new EMFactoryImpl());
		PersistenceManager.setUpTestConnection(PersistenceType.MYSQL_TEST);
	}

}
