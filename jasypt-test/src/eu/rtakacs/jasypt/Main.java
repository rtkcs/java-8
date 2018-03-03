package eu.rtakacs.jasypt;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.Cipher;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.jasypt.registry.AlgorithmRegistry;

/**
 * Main encryption tests.
 *
 * @author nobulletnav
 */
public class Main {

    static final String DATA = "{json:{userId:'12345678901234567890'}}";
    static final Logger logger = Logger.getGlobal();

    public static void main(String[] args) {
        String format = "%s\t%s";
        String line = padTo("", '-', 80);
        int keyLength = getJCEMaxKeyLength();
        String jce = keyLength == Integer.MAX_VALUE ? "YES" : "NO";
        // Collect test results.
        Set<String> algorithms = (Set<String>) AlgorithmRegistry.getAllPBEAlgorithms();
        Set<String> algorithmsModifiable = new LinkedHashSet<String>(algorithms);
        algorithmsModifiable.add("PBEWITHSHAAND256BITAES-CBC-BC");
        List<String> result = new ArrayList<>();
        for (String algorithm : algorithmsModifiable) {
            AlgoritmTestResult works = testAlgorithm(algorithm);
            result.add(String.format(format, padTo(algorithm), padTo(works.toString())));
        }
        // Print response.
        System.out.println(line);
        System.out.println(String.format("Version: %s, max key length: %d (JCE: %s)",
                System.getProperty("java.version"), keyLength, jce) + "\n" + line);
        System.out.println(String.format(format, padTo("Algorithm"), padTo("Result"))
                + "\n" + line);
        for (String r : result) {
            System.out.println(r);
        }
    }

    public static int getJCEMaxKeyLength() {
        try {
            return Cipher.getMaxAllowedKeyLength("AES");
        } catch (NoSuchAlgorithmException ex) {
            return -1;
        }
    }

    public static AlgoritmTestResult testAlgorithm(String algorithm) {
        boolean isEncrypted = false;
        try {
            StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
            encryptor.setPassword("wiu34we233[]weuokw/12340645798/3@#4");
            encryptor.setAlgorithm(algorithm);
            encryptor.setKeyObtentionIterations(1);
            String encrypted = encryptor.encrypt(DATA);
            isEncrypted = true;
            return DATA.equals(encryptor.decrypt(encrypted)) ? AlgoritmTestResult.OK : AlgoritmTestResult.DECRYPT_FAIL;
        } catch (org.jasypt.exceptions.EncryptionOperationNotPossibleException e) {
            logger.log(Level.WARNING, "Error while using " + algorithm + " ", e);
            return isEncrypted ? AlgoritmTestResult.NOT_POSSIBLE_DECRYPT : AlgoritmTestResult.NOT_POSSIBLE;
        } catch (Exception e) {
            logger.log(Level.WARNING, "Error while using " + algorithm + " ", e);
            return AlgoritmTestResult.UNKNOWN;
        }
    }

    public static String padTo(String s) {
        return padTo(s, 30);
    }

    public static String padTo(String s, char c, int length) {
        if (s.length() < length) {
            StringBuilder sb = new StringBuilder(s);
            for (int i = 0; i < length - s.length(); i++) {
                sb.append(c);
            }
            return sb.toString();
        }
        return s;
    }

    public static String padTo(String s, int length) {
        return padTo(s, ' ', length);
    }

    public static enum AlgoritmTestResult {

        OK,
        DECRYPT_FAIL,
        NOT_POSSIBLE,
        NOT_POSSIBLE_DECRYPT,
        UNKNOWN;
    }
}