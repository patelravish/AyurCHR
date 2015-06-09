package fv.ayurchr.dbobjects.hibernate;

/**
 * Created by Ravish Patel.
 * fv.ayurchr.dbobjects.hibernate.User: ravish
 * Date: 1/5/11
 * Time: 6:13 PM
 */
public class Role {
    private long Id = -1;
    private String RoleName = "";
    public static final String ENTITY = "ROLE";

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getRoleName() {
        return RoleName;
    }

    public void setRoleName(String roleName) {
        RoleName = roleName;
    }

    @Override
    public String toString() {
        return "fv.ayurchr.dbobjects.hibernate.Role{" +
                "Id=" + Id +
                ", RoleName='" + RoleName + '\'' +
                '}';
    }
}
