package clast.census.mysql.session;

import clast.census.core.persistence.EMFactoryImpl;
import clast.census.core.persistence.PersistenceManager;
import clast.census.core.persistence.PersistenceType;
import clast.census.core.session.AbstractSessionTest;

public class MySqlSessionIT extends AbstractSessionTest {

	@Override
	public void configurePersistenceUnit() {
		PersistenceManager.setEmFactory(new EMFactoryImpl());
		PersistenceManager.setUpTestConnection(PersistenceType.MYSQL_TEST);
	}

}
