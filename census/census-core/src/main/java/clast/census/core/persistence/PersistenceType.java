package clast.census.core.persistence;

public enum PersistenceType {
	
	HSQL_TEST("hsql_pu_test"), MYSQL("mysql_pu"), MYSQL_TEST("mysql_pu_test"), MONGO("mongo_pu"), MONGO_TEST("mongo_pu_test");
	
	private final String persistenceUnit;
	
	private PersistenceType(String persistenceUnit) {
		this.persistenceUnit = persistenceUnit;
	}

	public String getPersistenceUnit() {
		return persistenceUnit;
	}
	
}
