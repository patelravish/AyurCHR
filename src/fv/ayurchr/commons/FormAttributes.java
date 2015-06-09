package fv.ayurchr.commons;

/**
 * Created by Ravish Patel.
 * fv.ayurchr.dbobjects.hibernate.User: ravish
 * Date: 1/5/11
 * Time: 4:40 PM
 */
public class FormAttributes {
    private Class CLASS;
    private boolean ISNEW = true;
    private Long Id;
    private String Entity;
    private String Action;
    public static String MODIFY = "MODIFY";
    public static String DELETE = "DELETE";
    public static String ADD = "ADD";

    public String getEntity() {
        return Entity;
    }

    public void setEntity(String entity) {
        Entity = entity;
    }

    public Class getCLASS() {
        return CLASS;
    }

    public void setCLASS(Class CLASS) {
        this.CLASS = CLASS;
    }

    public boolean isISNEW() {
        return ISNEW;
    }

    public void setISNEW(boolean ISNEW) {
        this.ISNEW = ISNEW;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getAction() {
        return Action;
    }

    public void setAction(String action) {
        Action = action;
    }
}
