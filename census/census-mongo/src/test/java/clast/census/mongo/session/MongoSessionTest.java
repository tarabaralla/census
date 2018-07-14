package clast.census.mongo.session;

import clast.census.core.persistence.PersistenceManager;
import clast.census.core.session.AbstractSessionTest;

public class MongoSessionTest extends AbstractSessionTest {

	@Override
	public void configurePersistenceUnit() {
		PersistenceManager.setUpTestConnection("mongo_pu_test");
	}

}
