package clast.census.mysql.dao;

import clast.census.core.dao.AbstractUserRoleRelationDaoIT;
import clast.census.core.persistence.PersistenceManager;
import clast.census.core.persistence.PersistenceType;

public class MySqlUserRoleRelationDaoIT extends AbstractUserRoleRelationDaoIT {
	
	@Override
	public void configurePersistenceUnit() {
		PersistenceManager.setUpTestConnection(PersistenceType.MYSQL_TEST);
	}

}
