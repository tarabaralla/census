package clast.census.mysql.session;

import clast.census.core.persistence.PersistenceManager;
import clast.census.core.session.AbstractSessionTest;

public abstract class MySqlSessionTest extends AbstractSessionTest {

	@Override
	public void configurePersistenceUnit() {
		PersistenceManager.setUpTestConnection("mysql_pu_test");
	}

}
