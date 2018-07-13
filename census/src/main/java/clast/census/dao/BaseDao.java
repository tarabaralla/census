package clast.census.dao;

import javax.persistence.EntityManager;

import clast.census.persistence.PersistenceManager;

public interface BaseDao {
	
	default EntityManager getEntityManager() {
		return PersistenceManager.getEntityManager();
	}

}
