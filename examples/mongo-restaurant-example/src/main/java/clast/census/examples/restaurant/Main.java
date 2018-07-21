package clast.census.examples.restaurant;

import org.apache.log4j.Logger;

import clast.census.core.dao.RoleDao;
import clast.census.core.dao.UserDao;
import clast.census.core.model.Role;
import clast.census.core.model.User;
import clast.census.core.persistence.PersistenceManager;

public class Main {

	private static final Logger logger;
	
	private static RoleDao roleDao;
	private static UserDao userDao;
	
	static {
	        
		logger = Logger.getLogger(Main.class);
		
		PersistenceManager.setUpMongoConnection("localhost", "27017", "restaurant");
		
		roleDao = new RoleDao();
		userDao = new UserDao();
		
	}
	
	public static void main(String[] args) {
		
		if( roleDao.findAllRoles().isEmpty() && userDao.findAllUsers().isEmpty() ) {

			initRestaurantOrganizationalChart();
			
			initKitchenBrigade();
		
		}
		
		printKitchenBrigade();
		
		PersistenceManager.tearDownDbConnection();
		
	}

	private static void initRestaurantOrganizationalChart() {
		
		Role executiveChef = new Role("executive-chef");
		Role chefDeCusine = new Role("chef-de-cusine");
		Role sousChef = new Role("sous-chef");
		Role specializedChef = new Role("specialized-chef");
		Role gardeMangerChef = new Role("garde-manger-chef");
		Role saucierChef = new Role("saucier-chef");
		Role poissonierChef = new Role("poissonier-chef");
		Role rotisseurChef = new Role("rotisseur-chef");
		Role entremetierChef = new Role("entremetier-chef");
		
		Role assistant = new Role("assistant");
		Role commis = new Role("commis");
		Role plongeur = new Role("plongeur");
		Role apprentice = new Role("apprentice");
		
		roleDao.createRole(executiveChef);
		roleDao.createRole(chefDeCusine);
		roleDao.createRole(sousChef);
		roleDao.createRole(specializedChef);
		roleDao.createRole(gardeMangerChef);
		roleDao.createRole(saucierChef);
		roleDao.createRole(poissonierChef);
		roleDao.createRole(rotisseurChef);
		roleDao.createRole(entremetierChef);
		roleDao.createRole(assistant);
		roleDao.createRole(commis);
		roleDao.createRole(plongeur);
		roleDao.createRole(apprentice);
		
		roleDao.addSubRole(specializedChef, gardeMangerChef);
		roleDao.addSubRole(specializedChef, saucierChef);
		roleDao.addSubRole(specializedChef, poissonierChef);
		roleDao.addSubRole(specializedChef, rotisseurChef);
		roleDao.addSubRole(specializedChef, entremetierChef);
		
		roleDao.addSubRole(assistant, commis);
		roleDao.addSubRole(assistant, plongeur);
		roleDao.addSubRole(assistant, apprentice);
		
		roleDao.addManagedRole(executiveChef, chefDeCusine);
		roleDao.addManagedRole(chefDeCusine, sousChef);
		roleDao.addManagedRole(chefDeCusine, specializedChef);
		roleDao.addManagedRole(chefDeCusine, assistant);
		roleDao.addManagedRole(sousChef, specializedChef);
		roleDao.addManagedRole(sousChef, assistant);
		roleDao.addManagedRole(specializedChef, assistant);
		
	}

	private static void initKitchenBrigade() {
		
		User john = new User("johnsmith", "abc123");
		john.setName("John");
		john.setLastname("Smith");
		john.setEmail("john.smith@restaurant.com");
		
		userDao.createUser(john);
		userDao.addRole(john, roleDao.findRoleByName("executive-chef"));
		userDao.addRole(john, roleDao.findRoleByName("chef-de-cusine"));
		
		User martha = new User("martha", "m4rth4");
		martha.setName("Martha");
		martha.setLastname("Brown");
		martha.setEmail("martha.brown@restaurant.com");
		userDao.createUser(martha);
		userDao.addRole(martha, roleDao.findRoleByName("sous-chef"));
		
		User peter = new User("petergreen", "peter123");
		userDao.createUser(peter);
		userDao.addRole(peter, roleDao.findRoleByName("garde-manger-chef"));
		
		User jack = new User("jackwhite", "wh1te");
		userDao.createUser(jack);
		userDao.addRole(jack, roleDao.findRoleByName("saucier-chef"));
		
		User chris = new User("chrisblack", "mypwd");
		userDao.createUser(chris);
		userDao.addRole(chris, roleDao.findRoleByName("rotisseur-chef"));
		
		User sarah = new User("sarahdavis", "sarah84");
		userDao.createUser(sarah);
		userDao.addRole(sarah, roleDao.findRoleByName("apprentice"));
		
	}

	private static void printKitchenBrigade() {
		
		logger.info("-----------------------------------------------");
		logger.info("---------- Restaurant kitchen brigade ----------");
		logger.info("-----------------------------------------------");
		
		for( User user : userDao.findAllUsers() ) {
			
			String userRoles = "[ ";
			for( Role role : userDao.findAllRoles(user) ) {
				userRoles = userRoles + role.getName() + ", ";
			}
			userRoles = userRoles.substring(0, userRoles.lastIndexOf(',')) + " ]";
			
			logger.info( user.getUsername() + " " + userRoles );
		}
		
		logger.info("-----------------------------------------------");
		logger.info("-----------------------------------------------");
		
	}

}
