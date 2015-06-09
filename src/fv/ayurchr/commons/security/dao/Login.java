package fv.ayurchr.commons.security.dao;

import fv.ayurchr.commons.SV;
import fv.ayurchr.commons.security.util.EncryptionUtil;
import fv.ayurchr.commons.utils.LoggerUtils;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Login {
    private static Logger LOGGER = LoggerUtils.getLogger();
    private Long id;
    private String userName;
    private String password;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        try {
            if (password != null) {
                this.password = EncryptionUtil.encryptString(password, SV.ENCRYPT_ALGORITHM);
            }
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error while encrypting password.");
            e.printStackTrace();
        }
    }

}
