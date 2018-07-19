package clast.census.core.persistence;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PersistenceManagerTest {
	
	private EMFactory emFactory;
	private EntityManager em;
	
	@Before
	public void setUp() {
		
		em = mock(EntityManager.class);
		when(em.isOpen()).thenReturn(true);
		
		emFactory = mock(EMFactory.class);
		when(emFactory.createEntityManager(anyString(), any())).thenReturn(em);
		when(emFactory.createEntityManager(anyString())).thenReturn(em);
		
		PersistenceManager.setEmFactory(emFactory);
	}
	
	@After
	public void tearDown() {
		PersistenceManager.tearDownDbConnection();
	}

	@Test
	public void testSetUpMongoConnection() {
	
		Map<String, Object> persistenceMap = new HashMap<>();
		persistenceMap.put("kundera.nodes", "localhost");
		persistenceMap.put("kundera.port", "27017");
		persistenceMap.put("kundera.keyspace", "censusDB");
		persistenceMap.put("kundera.dialect", "mongodb");
		persistenceMap.put("kundera.ddl.auto.prepare", "update");
		persistenceMap.put("kundera.client.lookup.class", "com.impetus.client.mongodb.MongoDBClientFactory");
		
		when(em.getProperties()).thenReturn(persistenceMap);
		
		PersistenceManager.setUpMongoConnection("localhost", "27017", "censusDB");
		
		Map<String, Object> properties = PersistenceManager.getEntityManager().getProperties();
		
		assertEquals(persistenceMap.size(), properties.size());
		assertEquals(persistenceMap.get("kundera.nodes"), properties.get("kundera.nodes"));
		assertEquals(persistenceMap.get("kundera.port"), properties.get("kundera.port"));
		assertEquals(persistenceMap.get("kundera.keyspace"), properties.get("kundera.keyspace"));
		assertEquals(persistenceMap.get("kundera.dialect"), properties.get("kundera.dialect"));
		assertEquals(persistenceMap.get("kundera.ddl.auto.prepare"), properties.get("kundera.ddl.auto.prepare"));
		assertEquals(persistenceMap.get("kundera.client.lookup.class"), properties.get("kundera.client.lookup.class"));
		
	}
	
	@Test
	public void testSetUpPreExistentMongoConnection() {
		
		Map<String, Object> persistenceMap = new HashMap<>();
		persistenceMap.put("kundera.nodes", "localhost");
		persistenceMap.put("kundera.port", "27017");
		persistenceMap.put("kundera.keyspace", "censusDB");
		persistenceMap.put("kundera.dialect", "mongodb");
		persistenceMap.put("kundera.ddl.auto.prepare", "update");
		persistenceMap.put("kundera.client.lookup.class", "com.impetus.client.mongodb.MongoDBClientFactory");
		
		when(em.getProperties()).thenReturn(persistenceMap);
		
		PersistenceManager.setUpMongoConnection("localhost", "27017", "censusDB");
		PersistenceManager.setUpMongoConnection("localhost2", "27018", "censusDB2");
		
		Map<String, Object> properties = PersistenceManager.getEntityManager().getProperties();
		
		assertEquals(persistenceMap.size(), properties.size());
		assertEquals(persistenceMap.get("kundera.nodes"), properties.get("kundera.nodes"));
		assertEquals(persistenceMap.get("kundera.port"), properties.get("kundera.port"));
		assertEquals(persistenceMap.get("kundera.keyspace"), properties.get("kundera.keyspace"));
		assertEquals(persistenceMap.get("kundera.dialect"), properties.get("kundera.dialect"));
		assertEquals(persistenceMap.get("kundera.ddl.auto.prepare"), properties.get("kundera.ddl.auto.prepare"));
		assertEquals(persistenceMap.get("kundera.client.lookup.class"), properties.get("kundera.client.lookup.class"));
		
	}
	
	@Test
	public void testSetUpMySQLConnection() {
		
		Map<String, Object> persistenceMap = new HashMap<>();
		persistenceMap.put("javax.persistence.validation.mode", "none");
		persistenceMap.put("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
		persistenceMap.put("hibernate.connection.url", "jdbc:mysql://localhost:3307/censusdb");
		persistenceMap.put("hibernate.connection.username", "root");
		persistenceMap.put("hibernate.connection.password", "root");
		persistenceMap.put("hibernate.dialect", "org.hibernate.dialect.MySQL5InnoDBDialect");
		persistenceMap.put("hibernate.hbm2ddl.auto", "update");
		persistenceMap.put("hibernate.show_sql", "false");
		persistenceMap.put("hibernate.format_sql", "false");
		persistenceMap.put("hibernate.default_batch_fetch_size", "16");
		
		when(em.getProperties()).thenReturn(persistenceMap);
		
		PersistenceManager.setUpMySQLConnection("jdbc:mysql://localhost:3307/censusdb", "root", "root");
		
		Map<String, Object> properties = PersistenceManager.getEntityManager().getProperties();
		
		assertEquals(persistenceMap.size(), properties.size());
		assertEquals(persistenceMap.get("javax.persistence.validation.mode"), properties.get("javax.persistence.validation.mode"));
		assertEquals(persistenceMap.get("hibernate.connection.driver_class"), properties.get("hibernate.connection.driver_class"));
		assertEquals(persistenceMap.get("hibernate.connection.url"), properties.get("hibernate.connection.url"));
		assertEquals(persistenceMap.get("hibernate.connection.username"), properties.get("hibernate.connection.username"));
		assertEquals(persistenceMap.get("hibernate.connection.password"), properties.get("hibernate.connection.password"));
		assertEquals(persistenceMap.get("hibernate.dialect"), properties.get("hibernate.dialect"));
		assertEquals(persistenceMap.get("hibernate.hbm2ddl.auto"), properties.get("hibernate.hbm2ddl.auto"));
		assertEquals(persistenceMap.get("hibernate.show_sql"), properties.get("hibernate.show_sql"));
		assertEquals(persistenceMap.get("hibernate.format_sql"), properties.get("hibernate.format_sql"));
		assertEquals(persistenceMap.get("hibernate.default_batch_fetch_size"), properties.get("hibernate.default_batch_fetch_size"));
		
	}
	
	@Test
	public void testSetUpPreExistentMySQLConnection() {
		
		Map<String, Object> persistenceMap = new HashMap<>();
		persistenceMap.put("javax.persistence.validation.mode", "none");
		persistenceMap.put("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
		persistenceMap.put("hibernate.connection.url", "jdbc:mysql://localhost:3307/censusdb");
		persistenceMap.put("hibernate.connection.username", "root");
		persistenceMap.put("hibernate.connection.password", "root");
		persistenceMap.put("hibernate.dialect", "org.hibernate.dialect.MySQL5InnoDBDialect");
		persistenceMap.put("hibernate.hbm2ddl.auto", "update");
		persistenceMap.put("hibernate.show_sql", "false");
		persistenceMap.put("hibernate.format_sql", "false");
		persistenceMap.put("hibernate.default_batch_fetch_size", "16");
		
		when(em.getProperties()).thenReturn(persistenceMap);
		
		PersistenceManager.setUpMySQLConnection("jdbc:mysql://localhost:3307/censusdb", "root", "root");
		PersistenceManager.setUpMySQLConnection("jdbc:mysql://localhost:3307/censusdb2", "root2", "root2");
		
		Map<String, Object> properties = PersistenceManager.getEntityManager().getProperties();
		
		assertEquals(persistenceMap.size(), properties.size());
		assertEquals(persistenceMap.get("javax.persistence.validation.mode"), properties.get("javax.persistence.validation.mode"));
		assertEquals(persistenceMap.get("hibernate.connection.driver_class"), properties.get("hibernate.connection.driver_class"));
		assertEquals(persistenceMap.get("hibernate.connection.url"), properties.get("hibernate.connection.url"));
		assertEquals(persistenceMap.get("hibernate.connection.username"), properties.get("hibernate.connection.username"));
		assertEquals(persistenceMap.get("hibernate.connection.password"), properties.get("hibernate.connection.password"));
		assertEquals(persistenceMap.get("hibernate.dialect"), properties.get("hibernate.dialect"));
		assertEquals(persistenceMap.get("hibernate.hbm2ddl.auto"), properties.get("hibernate.hbm2ddl.auto"));
		assertEquals(persistenceMap.get("hibernate.show_sql"), properties.get("hibernate.show_sql"));
		assertEquals(persistenceMap.get("hibernate.format_sql"), properties.get("hibernate.format_sql"));
		assertEquals(persistenceMap.get("hibernate.default_batch_fetch_size"), properties.get("hibernate.default_batch_fetch_size"));
		
	}
	
	@Test
	public void testSetUpTestConnection() {
		
		Map<String, Object> persistenceMap = new HashMap<>();
		persistenceMap.put("kundera.nodes", "localhost");
		persistenceMap.put("kundera.port", "27017");
		persistenceMap.put("kundera.keyspace", "censusDB");
		persistenceMap.put("kundera.dialect", "mongodb");
		persistenceMap.put("kundera.ddl.auto.prepare", "create-drop");
		persistenceMap.put("kundera.client.lookup.class", "com.impetus.client.mongodb.MongoDBClientFactory");
		
		when(em.getProperties()).thenReturn(persistenceMap);
		
		PersistenceManager.setUpTestConnection(PersistenceType.MONGO_TEST);
		
		Map<String, Object> properties = PersistenceManager.getEntityManager().getProperties();
		
		assertEquals(persistenceMap.size(), properties.size());
		assertEquals(persistenceMap.get("kundera.nodes"), properties.get("kundera.nodes"));
		assertEquals(persistenceMap.get("kundera.port"), properties.get("kundera.port"));
		assertEquals(persistenceMap.get("kundera.keyspace"), properties.get("kundera.keyspace"));
		assertEquals(persistenceMap.get("kundera.dialect"), properties.get("kundera.dialect"));
		assertEquals(persistenceMap.get("kundera.ddl.auto.prepare"), properties.get("kundera.ddl.auto.prepare"));
		assertEquals(persistenceMap.get("kundera.client.lookup.class"), properties.get("kundera.client.lookup.class"));
		
	}
	
	@Test
	public void testSetUpPreExistentTestConnection() {
		
		Map<String, Object> persistenceMap = new HashMap<>();
		persistenceMap.put("kundera.nodes", "localhost");
		persistenceMap.put("kundera.port", "27017");
		persistenceMap.put("kundera.keyspace", "censusDB");
		persistenceMap.put("kundera.dialect", "mongodb");
		persistenceMap.put("kundera.ddl.auto.prepare", "create-drop");
		persistenceMap.put("kundera.client.lookup.class", "com.impetus.client.mongodb.MongoDBClientFactory");
		
		when(em.getProperties()).thenReturn(persistenceMap);
		
		PersistenceManager.setUpTestConnection(PersistenceType.MONGO_TEST);
		PersistenceManager.setUpTestConnection(PersistenceType.MONGO_TEST);
		
		Map<String, Object> properties = PersistenceManager.getEntityManager().getProperties();
		
		assertEquals(persistenceMap.size(), properties.size());
		assertEquals(persistenceMap.get("kundera.nodes"), properties.get("kundera.nodes"));
		assertEquals(persistenceMap.get("kundera.port"), properties.get("kundera.port"));
		assertEquals(persistenceMap.get("kundera.keyspace"), properties.get("kundera.keyspace"));
		assertEquals(persistenceMap.get("kundera.dialect"), properties.get("kundera.dialect"));
		assertEquals(persistenceMap.get("kundera.ddl.auto.prepare"), properties.get("kundera.ddl.auto.prepare"));
		assertEquals(persistenceMap.get("kundera.client.lookup.class"), properties.get("kundera.client.lookup.class"));
		
	}
	
	@Test
	public void testSetUpTestConnectionWithNullPU() {
		when(emFactory.createEntityManager(anyString())).thenReturn(null);
		PersistenceManager.setUpTestConnection(null);
		assertNull(PersistenceManager.getEntityManager());
	}
	
	@Test
	public void testTearDownDbConnection() {
		PersistenceManager.setUpTestConnection(PersistenceType.MONGO_TEST);
		when(em.isOpen()).thenReturn(false);
		PersistenceManager.tearDownDbConnection();
	}
	
	@Test
	public void testConstructorIsPrivate() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
	  Constructor<PersistenceManager> constructor = PersistenceManager.class.getDeclaredConstructor();
	  assertTrue(Modifier.isPrivate(constructor.getModifiers()));
	  constructor.setAccessible(true);
	  constructor.newInstance();
	}

}
