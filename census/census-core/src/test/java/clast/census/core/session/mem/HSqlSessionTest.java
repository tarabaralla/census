package clast.census.core.session.mem;

import clast.census.core.persistence.PersistenceManager;
import clast.census.core.persistence.PersistenceType;
import clast.census.core.session.AbstractSessionTest;

public abstract class HSqlSessionTest extends AbstractSessionTest {

	@Override
	public void configurePersistenceUnit() {
		PersistenceManager.setUpTestConnection(PersistenceType.HSQL_TEST);
	}

}
