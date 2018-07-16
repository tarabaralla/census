package clast.census.mem.session;

import clast.census.core.persistence.PersistenceManager;
import clast.census.core.session.AbstractSessionIT;

public abstract class HSqlSessionIT extends AbstractSessionIT {

	@Override
	public void configurePersistenceUnit() {
		PersistenceManager.setUpTestConnection("hsql_pu_test");
	}

}
