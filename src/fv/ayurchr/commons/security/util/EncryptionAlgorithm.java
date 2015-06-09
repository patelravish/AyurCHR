/**
 *
 */
package fv.ayurchr.commons.security.util;

/**
 * @author jrawal
 */
public enum EncryptionAlgorithm {
    SHA1("SHA1"),
    SHA_256("SHA-256"),
    SHA_512("SHA-512");


    EncryptionAlgorithm(String value) {
        this.setValue(value);
    }

    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}
