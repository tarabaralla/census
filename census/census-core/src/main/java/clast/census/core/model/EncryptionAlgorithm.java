package clast.census.core.model;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public interface EncryptionAlgorithm {
	
	public MessageDigest getMessageDigest(String plainPassword) throws NoSuchAlgorithmException ;

}
