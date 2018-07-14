package clast.census.core.dao;

import javax.persistence.EntityManager;

import clast.census.core.persistence.PersistenceManager;

public interface BaseDao {
	
	default EntityManager getEntityManager() {
		return PersistenceManager.getEntityManager();
	}

}
