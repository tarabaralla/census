package clast.census.core.session.mem;

import clast.census.core.persistence.EMFactoryImpl;
import clast.census.core.persistence.PersistenceManager;
import clast.census.core.persistence.PersistenceType;
import clast.census.core.session.AbstractSessionTest;

public class HSqlSessionTest extends AbstractSessionTest {

	@Override
	public void configurePersistenceUnit() {
		PersistenceManager.setEmFactory(new EMFactoryImpl());
		PersistenceManager.setUpTestConnection(PersistenceType.HSQL_TEST);
	}

}
