package clast.census.mem.session;

import clast.census.core.persistence.PersistenceManager;
import clast.census.core.session.AbstractSessionTest;

public class HSqlSessionTest extends AbstractSessionTest {

	@Override
	public void configurePersistenceUnit() {
		PersistenceManager.setUpTestConnection("hsql_pu_test");
	}

}
