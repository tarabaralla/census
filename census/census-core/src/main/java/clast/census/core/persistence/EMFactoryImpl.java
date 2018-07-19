package clast.census.core.persistence;

import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class EMFactoryImpl implements EMFactory {

	@Override
	public EntityManager createEntityManager(String persistenceUnit, Map<String, String> properties) {
		return Persistence.createEntityManagerFactory(persistenceUnit,properties).createEntityManager();
	}
	
	@Override
	public EntityManager createEntityManager(String persistenceUnit) {
		return Persistence.createEntityManagerFactory(persistenceUnit).createEntityManager();
	}
	
}
