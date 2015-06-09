package fv.ayurchr.commons;

import fv.ayurchr.commons.security.util.EncryptionAlgorithm;

public class SV {
    public static boolean isDev = true;
    public static String secuirity_page = "/common/security/Login.jsp";
    public final static EncryptionAlgorithm ENCRYPT_ALGORITHM = EncryptionAlgorithm.SHA1;
    public final static String HomePage = "index.jsp";
    public final static int LoginCapacity = 100;
}
