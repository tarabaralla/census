package clast.census.mysql.session;

import clast.census.core.persistence.PersistenceManager;
import clast.census.core.session.AbstractSessionIT;

public abstract class MySqlSessionIT extends AbstractSessionIT {

	@Override
	public void configurePersistenceUnit() {
		PersistenceManager.setUpTestConnection("mysql_pu_test");
	}

}
