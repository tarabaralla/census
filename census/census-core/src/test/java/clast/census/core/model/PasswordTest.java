package clast.census.core.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;

import java.security.NoSuchAlgorithmException;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class PasswordTest {
	
	private Password password;
	
	@Rule
	public ExpectedException expectedEx = ExpectedException.none();
	
	@Before
	public void setUp() {
		password = new Password("123");
	}
	
	@Test
	public void testValue() {
		password = new Password();
		password.setValue("123");
		assertEquals("123",password.getValue());
	}

	@Test
	public void testEncryptPassword() {
		password.encryptPassword("password");
		assertTrue(password.checkPassword("password"));
	}
	
	@Test
	public void testEncryptNullPassword() {
		expectedEx.expect(IllegalArgumentException.class);
		expectedEx.expectMessage("Unable to encrypt password: plainpassword cannot be null.");
		
		password.encryptPassword(null);
	}
	
	@Test
	public void testEncryptBlankPassword() {
		password.encryptPassword("");
		assertTrue(password.checkPassword(""));
	}
	
	@Test
	public void testCheckNullPassword() {
		assertFalse(password.checkPassword(null));
	}
	
	@Test
	public void testCheckEmptyPassword() {
		password.encryptPassword("");
		assertTrue(password.checkPassword(""));
	}
	
	@Test
	public void testCheckWrongPassword1() {
		password.setValue(null);
		assertFalse(password.checkPassword(""));
	}
	
	@Test
	public void testCheckWrongPassword2() {
		password.encryptPassword("pwd");
		assertFalse(password.checkPassword(""));
	}
	
	@Test
	public void testNoSuchAlgorithmException() {

		expectedEx.expect(IllegalStateException.class);
		expectedEx.expectMessage("Unable to encrypt: encryption algorithm not found.");
		
		try {
		
			EncryptionAlgorithm ea = mock(EncryptionAlgorithm.class);
			doThrow(new NoSuchAlgorithmException()).when(ea).getMessageDigest(anyString());
			password.setEncryptionAlgorithm(ea);
			
			password.encryptPassword("password");
			
		}catch (NoSuchAlgorithmException e) {
			fail();
		}
		fail();
	}

}
