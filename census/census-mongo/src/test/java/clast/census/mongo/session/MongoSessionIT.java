package clast.census.mongo.session;

import clast.census.core.persistence.PersistenceManager;
import clast.census.core.session.AbstractSessionIT;

public abstract class MongoSessionIT extends AbstractSessionIT {

	@Override
	public void configurePersistenceUnit() {
		PersistenceManager.setUpTestConnection("mongo_pu_test");
	}

}
