package fv.ayurchr.commons.security.util;

import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author jrawal
 */
public class EncryptionUtil {
    /**
     * To encrypt user script.
     *
     * @param inputString
     * @return
     * @throws Exception
     */
    public static String encryptString(String inputString, EncryptionAlgorithm algorithm) throws Exception {
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance(algorithm.getValue()); // step 1
            md.update(inputString.getBytes("UTF-8")); // step 2
            byte raw[] = md.digest(); // step 3
            String hash = (new BASE64Encoder()).encode(raw); // step 4
            return hash; // step 5
        } catch (NoSuchAlgorithmException e) {
            throw new Exception(e.getMessage());
        } catch (UnsupportedEncodingException e) {
            throw new Exception(e.getMessage());
        }
    }

}
