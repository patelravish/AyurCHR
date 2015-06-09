package fv.ayurchr.dbobjects.hibernate;

public class Problem {
    private long Id = -1;
    private String Description = "";
    public static String ENTITY = "PROBLEM";

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    @Override
    public String toString() {
        return "fv.ayurchr.dbobjects.hibernate.Problem{" +
                "Id=" + Id +
                ", Description='" + Description + '\'' +
                '}';
    }
}
