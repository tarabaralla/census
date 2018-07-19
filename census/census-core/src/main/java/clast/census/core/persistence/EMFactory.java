package clast.census.core.persistence;

import java.util.Map;

import javax.persistence.EntityManager;

public interface EMFactory {
	
	public EntityManager createEntityManager(String persistenceUnit, Map<String, String> properties);

	public EntityManager createEntityManager(String persistenceUnit);
}
