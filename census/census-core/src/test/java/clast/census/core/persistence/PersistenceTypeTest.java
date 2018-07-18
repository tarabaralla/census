package clast.census.core.persistence;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PersistenceTypeTest {

	@Test
	public void testPersistenceType() {
		assertEquals(PersistenceType.HSQL_TEST, PersistenceType.valueOf(PersistenceType.HSQL_TEST.toString()));
		assertEquals(PersistenceType.MYSQL, PersistenceType.valueOf(PersistenceType.MYSQL.toString()));
		assertEquals(PersistenceType.MYSQL_TEST, PersistenceType.valueOf(PersistenceType.MYSQL_TEST.toString()));
		assertEquals(PersistenceType.MONGO, PersistenceType.valueOf(PersistenceType.MONGO.toString()));
		assertEquals(PersistenceType.MONGO_TEST, PersistenceType.valueOf(PersistenceType.MONGO_TEST.toString()));
	}

}
