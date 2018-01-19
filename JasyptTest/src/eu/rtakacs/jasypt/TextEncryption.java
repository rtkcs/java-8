package eu.rtakacs.jasypt;

import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.jasypt.util.password.ConfigurablePasswordEncryptor;
import org.jasypt.util.text.BasicTextEncryptor;
import org.jasypt.util.text.StrongTextEncryptor;

public class TextEncryption {

	public static void main(String[] args) {

		//
		//----- Basic Text Encryptor
		//
		String encryptionPassword = "cJsP123";
		String text = "cobra";
		BasicTextEncryptor basicTextEncryptor = new BasicTextEncryptor();
		basicTextEncryptor.setPassword(encryptionPassword);
		
		String encryptedText = basicTextEncryptor.encrypt(text);
		String plainText = basicTextEncryptor.decrypt(encryptedText);
		
		System.out.println();
		System.out.println("---------- Basic Text Encryptor ----------");
		System.out.println("Text = " + text);
		System.out.println("Encrypted Text = " + encryptedText);
		System.out.println("PlainText = " + plainText);

		
		//
		//----- Strong Text Encryptor
		//
		StrongTextEncryptor strongTextEncryptor = new StrongTextEncryptor();
		strongTextEncryptor.setPassword(encryptionPassword);
		encryptedText = strongTextEncryptor.encrypt(text);
		plainText = strongTextEncryptor.decrypt(encryptedText);
		
		System.out.println();
		System.out.println("---------- Basic Text Encryptor ----------");
		System.out.println("Text = " + text);
		System.out.println("Encrypted Text = " + encryptedText);
		
		//
		//----- Standard PBE Text Encryptor
		//		
		StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
		encryptor.setPassword(encryptionPassword);          // we HAVE TO set a password
		encryptor.setAlgorithm("PBEWithMD5AndDES");   		// optionally set the algorithm
		encryptedText = encryptor.encrypt(text);
		plainText = encryptor.decrypt(encryptedText);  		// myText.equals(plainText)
		
		System.out.println();
		System.out.println("---------- Standard PBE String Encryptor ----------");
		System.out.println("Password = " + text);
		System.out.println("Encrypted Password (PBEWithMD5AndDES) = " + encryptedText);
		System.out.println("Encrypted Password (algorithm not set) = " + encryptedText);
		
		plainText = encryptor.decrypt("lIHwBLxUxFNLXqgXOCGm9g==");
		System.out.println(plainText);

		//
		//----- Pooled PBE Text Encryptor
		//		
		PooledPBEStringEncryptor pooledEncryptor = new PooledPBEStringEncryptor();
		pooledEncryptor.setPoolSize(4);
		pooledEncryptor.setPassword(encryptionPassword);        // we HAVE TO set a password
		pooledEncryptor.setAlgorithm("PBEWithMD5AndDES");   	// optionally set the algorithm
		encryptedText = pooledEncryptor.encrypt(text);
		plainText = pooledEncryptor.decrypt(encryptedText);  	// myText.equals(plainText)
		
		System.out.println();
		System.out.println("---------- Pooled PBE String Encryptor ----------");
		System.out.println("Password = " + text);
		System.out.println("Encrypted Password (PBEWithMD5AndDES) = " + encryptedText);		
		
		//
		//----- Configurable Password Encryptor
		//
		ConfigurablePasswordEncryptor passwordEncryptor = new ConfigurablePasswordEncryptor();
		passwordEncryptor.setAlgorithm("SHA-1");
		passwordEncryptor.setPlainDigest(true);
		String encryptedPassword = passwordEncryptor.encryptPassword(text);
		
		System.out.println();
		System.out.println();
		System.out.println("---------- Configurable Password Encryptor ----------");
		System.out.println("Password = " + text);
		System.out.println("Encrypted Password (SHA-1) = " + encryptedPassword);
	}

}
