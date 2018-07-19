package clast.census.core.persistence;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;

import org.apache.log4j.Logger;

public class PersistenceManager {
	
	private static final Logger logger = Logger.getLogger(PersistenceManager.class);
	
	private static EMFactory emFactory;
	
	private static EntityManager em;
	private static PersistenceType pt;
	
	private PersistenceManager() {}
	
	static {
		emFactory = new EMFactoryImpl();
	}
	
	public static void setEmFactory(EMFactory emFactory) {
		PersistenceManager.emFactory = emFactory;
	}

	public static EntityManager getEntityManager() {
		return em;
	}
	
	public static void setUpMongoConnection(String host, String port, String dbName) {
		
		if( !PersistenceType.MONGO.equals(pt) ) {
		
			Map<String, String> persistenceMap = new HashMap<>();
	
			persistenceMap.put("kundera.nodes", host);
			persistenceMap.put("kundera.port", port);
			persistenceMap.put("kundera.keyspace", dbName);
			persistenceMap.put("kundera.dialect", "mongodb");
			persistenceMap.put("kundera.ddl.auto.prepare", "update");
			persistenceMap.put("kundera.client.lookup.class", "com.impetus.client.mongodb.MongoDBClientFactory");
			
			em = emFactory.createEntityManager("mongo_pu",persistenceMap);
			pt = PersistenceType.MONGO;
			logger.info("Initialized MONGO database");
		}
	}
	
	public static void setUpMySQLConnection(String url, String username, String password) {
		
		if( !PersistenceType.MYSQL.equals(pt) ) {
		
			Map<String, String> persistenceMap = new HashMap<>();
			
			persistenceMap.put("javax.persistence.validation.mode", "none");
			persistenceMap.put("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
			persistenceMap.put("hibernate.connection.url", url);
			persistenceMap.put("hibernate.connection.username", username);
			persistenceMap.put("hibernate.connection.password", password);
			persistenceMap.put("hibernate.dialect", "org.hibernate.dialect.MySQL5InnoDBDialect");
			persistenceMap.put("hibernate.hbm2ddl.auto", "update");
			persistenceMap.put("hibernate.show_sql", "false");
			persistenceMap.put("hibernate.format_sql", "false");
			persistenceMap.put("hibernate.default_batch_fetch_size", "16");
			
			em = emFactory.createEntityManager("mysql_pu",persistenceMap);
			pt = PersistenceType.MYSQL;
			logger.info("Initialized MYSQL database");
		}
	}
	
	public static void setUpTestConnection( PersistenceType persistenceType ) {
		if( persistenceType != null && !persistenceType.equals(pt) ) {
			em = emFactory.createEntityManager(persistenceType.getPersistenceUnit());
			pt = persistenceType;
			logger.info("Initialized " + persistenceType + " database");
		}
	}
	
	public static void tearDownDbConnection() {
		
		if(em != null ) {
			if( em.isOpen() ) {
				em.close();
			}
			em = null;
			pt = null;
		}
		
	}
	
}
