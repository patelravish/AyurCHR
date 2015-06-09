package fv.ayurchr.dbobjects.hibernate;

import java.util.Date;

/**
 * User: FormatVirus
 * Date: 2/5/12
 * Time: 9:56 PM
 */
public class Allergy {
    private long UserId;
    private long Id = 1;
    public static final String CENTITY = "CALLERGY";
    public static final String ENTITY = "ALLERGY";
    private String AllergyType = "";
    private Date StartDate;
    private Date EndDate;
    private String Reaction;
    private String Severity;
    private String Medication;
    private String Comments;

    public long getUserId() {
        return UserId;
    }

    public void setUserId(long userId) {
        UserId = userId;
    }

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getAllergyType() {
        return AllergyType;
    }

    public void setAllergyType(String allergyType) {
        AllergyType = allergyType;
    }

    public Date getStartDate() {
        return StartDate;
    }

    public void setStartDate(Date startDate) {
        StartDate = startDate;
    }

    public Date getEndDate() {
        return EndDate;
    }

    public void setEndDate(Date endDate) {
        EndDate = endDate;
    }

    public String getReaction() {
        return Reaction;
    }

    public void setReaction(String reaction) {
        Reaction = reaction;
    }

    public String getSeverity() {
        return Severity;
    }

    public void setSeverity(String severity) {
        Severity = severity;
    }

    public String getMedication() {
        return Medication;
    }

    public void setMedication(String medication) {
        Medication = medication;
    }

    public String getComments() {
        return Comments;
    }

    public void setComments(String comments) {
        Comments = comments;
    }
}
