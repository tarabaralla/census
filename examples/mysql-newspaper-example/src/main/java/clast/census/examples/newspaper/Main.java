package clast.census.examples.newspaper;

import java.util.HashSet;
import java.util.Set;

import javax.inject.Inject;

import org.apache.log4j.Logger;

import clast.census.core.dao.RoleDao;
import clast.census.core.dao.UserDao;
import clast.census.core.model.Role;
import clast.census.core.model.User;
import clast.census.core.persistence.PersistenceManager;
import clast.census.core.session.Session;

public class Main {
	
	private static final Logger logger;
	
	@Inject
	private static Session session;
	
	private static RoleDao roleDao;
	private static UserDao userDao;
	
	private static final String EDITOR_SECRETARY_USERNAME = "marthabrown";
	private static final String EDITOR_SECRETARY_TEMP_PASS = "m4rth4";
	private static final String EDITOR_SECRETARY_NEW_PASS = "br0wn";
	
	static {
	        
		logger = Logger.getLogger(Main.class);
		
		PersistenceManager.setUpMySQLConnection("jdbc:mysql://localhost:3306/newspaper?serverTimezone=UTC", "newspaperAdmin", "newspaperAdmin");
		
		roleDao = new RoleDao();
		userDao = new UserDao();
		
	}
	
	public static void main(String[] args) {
		
		if( roleDao.findAllRoles().isEmpty() && userDao.findAllUsers().isEmpty() ) {

			initNewspaperOrganizationalChart();
			
			initEditorialStaff();
		
		}
		
		printEditorialStaff();
		
		PersistenceManager.tearDownDbConnection();
		
	}

	private static void initNewspaperOrganizationalChart() {
		
		Role journalist = new Role("journalist");
		Role editor = new Role("editor");
		Role reporter = new Role("reporter");
		Role specialReporter = new Role("special-reporter");
		Role correspondent = new Role("correspondent");
		Role collaborator = new Role("collaborator");
		
		Role secretary = new Role("secretary");
		Role editorSecretary = new Role("editor-secretary");
	
		Role subscriber = new Role("subscriber-reader");
		
		roleDao.createRole(journalist);
		roleDao.createRole(editor);
		roleDao.createRole(reporter);
		roleDao.createRole(specialReporter);
		roleDao.createRole(correspondent);
		roleDao.createRole(collaborator);
		roleDao.createRole(secretary);
		roleDao.createRole(editorSecretary);
		roleDao.createRole(subscriber);
		
		roleDao.addSubRole(journalist, editor);
		roleDao.addSubRole(journalist, reporter);
		roleDao.addSubRole(reporter, specialReporter);
		roleDao.addSubRole(journalist, correspondent);
		roleDao.addSubRole(journalist, collaborator);
		
		roleDao.addSubRole(secretary, editorSecretary);
		
		roleDao.addManagedRole(editor, editorSecretary);
		
		roleDao.addManagedRole(editorSecretary, reporter);
		roleDao.addManagedRole(editorSecretary, specialReporter);
		roleDao.addManagedRole(editorSecretary, correspondent);
		roleDao.addManagedRole(editorSecretary, collaborator);
		
	}

	private static void initEditorialStaff() {
		
		User john = new User("johnsmith", "abc123");
		john.setName("John");
		john.setLastname("Smith");
		john.setEmail("john.smith@newspaper.com");
		
		userDao.createUser(john);
		userDao.addRole(john, roleDao.findRoleByName("editor"));
		
		User martha = new User("martha", EDITOR_SECRETARY_TEMP_PASS);
		martha.setName("Martha");
		martha.setLastname("Brown");
		martha.setEmail("martha.brown@newspaper.com");
		userDao.createUser(martha);
		userDao.addRole(martha, roleDao.findRoleByName("editor-secretary"));
		
		User peter = new User("petergreen", "peter123");
		userDao.createUser(peter);
		userDao.addRole(peter, roleDao.findRoleByName("reporter"));
		userDao.addRole(peter, roleDao.findRoleByName("correspondent"));
		
		User jack = new User("jackwhite", "wh1te");
		userDao.createUser(jack);
		userDao.addRole(jack, roleDao.findRoleByName("special-reporter"));
		
		User chris = new User("chrisblack", "mypwd");
		userDao.createUser(chris);
		userDao.addRole(chris, roleDao.findRoleByName("special-reporter"));
		
		User sarah = new User("sarahdavis", "sarah84");
		userDao.createUser(sarah);
		userDao.addRole(sarah, roleDao.findRoleByName("collaborator"));
		
	}

	private static void printEditorialStaff() {
		
		logger.info("-----------------------------------------------");
		logger.info("---------- Newspaper editorial staff ----------");
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
