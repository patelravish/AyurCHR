package fv.ayurchr.dbobjects.hibernate;

import java.util.Date;

import fv.ayurchr.commons.HibernateSession;

import static fv.ayurchr.commons.security.util.DAOUtility.getIncidenceObject;

public class Incidence {
    public static final String CENTITY = "CINCIDENCE";
    public static final String ENTITY = "INCIDENCE";
    private long Id = 1;
    private long UserId = 1;
    private User User;
    private String FirstName = "";
    private String LastName = "";
    private String MiddleName = "";
    private String Temperature = "";
    private String BloodPressure = "";
    private String Weight = "";
    private String Height = "";
    private Date AppointmentDate = new Date();
    private String Problem_1 = "";
    private long ProblemId_1 = -1;
    private String since_1 = "";
    private String Problem_2 = "";
    private long ProblemId_2 = -1;
    private String since_2 = "";
    private String Problem_3 = "";
    private long ProblemId_3 = -1;
    private String since_3 = "";
    private String Problem_4 = "";
    private long ProblemId_4 = -1;
    private String since_4 = "";
    private String Problem_5 = "";
    private long ProblemId_5 = -1;
    private String since_5 = "";
    private String Symptom_1 = "";
    private long SymptomId_1 = -1;
    private String Symptom_2 = "";
    private long SymptomId_2 = -1;
    private String Symptom_3 = "";
    private long SymptomId_3 = -1;
    private String Symptom_4 = "";
    private long SymptomId_4 = -1;
    private String Symptom_5 = "";
    private long SymptomId_5 = -1;
    private String Diagnosis_1 = "";
    private long DiagnosisId_1 = -1;
    private String Diagnosis_2 = "";
    private long DiagnosisId_2 = -1;
    private String Diagnosis_3 = "";
    private long DiagnosisId_3 = -1;
    private String Diagnosis_4 = "";
    private long DiagnosisId_4 = -1;
    private String Diagnosis_5 = "";
    private long DiagnosisId_5 = -1;
    private Date IncidenceDate = new Date();
    private String Medication_1 = "";
    private long MedicationId_1 = -1;
    private String Medication_2 = "";
    private long MedicationId_2 = -1;
    private String TimeId_1 = "";
    private String TimeId_2 = "";
    
    private String Comment = "";

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public long getUserId() {
        return UserId;
    }

    public void setUserId(long userId) {
    	if(getFirstName() == null || getLastName() == null || "".equals(getFirstName()) || "".equals(getLastName())){
    		HibernateSession hs = new HibernateSession();
    		setUser((User)hs.getEntity("USER", userId));
    		setFirstName(User.getFirstName());
        	setLastName(User.getLastName());
    	}
        UserId = userId;
    }

    public User getUser() {
        return User;
    }

    public void setUser(User user) {
        User = user;
    }

    public String getFirstName() {
    	
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getMiddleName() {
        return MiddleName;
    }

    public void setMiddleName(String middleName) {
        MiddleName = middleName;
    }

    public String getProblem_1() {
        return Problem_1;
    }

    public void setProblem_1(String problem_1) {
        Problem_1 = problem_1;
    }

    public long getProblemId_1() {
        return ProblemId_1;
    }

    public void setProblemId_1(long problemId_1) {
    	if(problemId_1 != -1 && (getProblem_1() == null || "".equals(getProblem_1())))
    	{
    		setProblem_1(getIncidenceObject("Finding", problemId_1).getAttributeDesc());
    	}
    	ProblemId_1 = problemId_1;
    }

    public String getProblem_2() {
        return Problem_2;
    }

    public void setProblem_2(String problem_2) {
        Problem_2 = problem_2;
    }

    public long getProblemId_2() {
        return ProblemId_2;
    }

    public void setProblemId_2(long problemId_2) {
    	if(problemId_2 != -1 && (getProblem_2() == null || "".equals(getProblem_2())))
    	{
    		setProblem_2(getIncidenceObject("Finding", problemId_2).getAttributeDesc());
    	}
        ProblemId_2 = problemId_2;
    }

    public String getProblem_3() {
        return Problem_3;
    }

    public void setProblem_3(String problem_3) {
        Problem_3 = problem_3;
    }

    public long getProblemId_3() {
        return ProblemId_3;
    }

    public void setProblemId_3(long problemId_3) {
    	if(problemId_3 != -1 && (getProblem_3() == null || "".equals(getProblem_3())))
    	{
    		setProblem_3(getIncidenceObject("Finding", problemId_3).getAttributeDesc());
    	}
        ProblemId_3 = problemId_3;
    }

    public String getProblem_4() {
        return Problem_4;
    }

    public void setProblem_4(String problem_4) {
        Problem_4 = problem_4;
    }

    public long getProblemId_4() {
        return ProblemId_4;
    }

    public void setProblemId_4(long problemId_4) {
    	if(problemId_4 != -1 && (getProblem_4() == null || "".equals(getProblem_4())))
    	{
    		setProblem_4(getIncidenceObject("Finding", problemId_4).getAttributeDesc());
    	}
        ProblemId_4 = problemId_4;
    }

    public String getProblem_5() {
        return Problem_5;
    }

    public void setProblem_5(String problem_5) {
        Problem_5 = problem_5;
    }

    public long getProblemId_5() {
        return ProblemId_5;
    }

    public void setProblemId_5(long problemId_5) {
    	if(problemId_5 != -1 && (getProblem_5() == null || "".equals(getProblem_5())))
    	{
    		setProblem_5(getIncidenceObject("Finding", problemId_5).getAttributeDesc());
    	}
        ProblemId_5 = problemId_5;
    }
   
    public String getSymptom_1() {
		return Symptom_1;
	}

	public void setSymptom_1(String symptom_1) {
		Symptom_1 = symptom_1;
	}

	public long getSymptomId_1() {
		return SymptomId_1;
	}

	public void setSymptomId_1(long symptomId_1) {
		if(symptomId_1 != -1 && (getSymptom_1() == null || "".equals(getSymptom_1())))
    	{
    		setSymptom_1(getIncidenceObject("Symptom", symptomId_1).getAttributeName());
    	}
		SymptomId_1 = symptomId_1;
	}

	public String getSymptom_2() {
		return Symptom_2;
	}

	public void setSymptom_2(String symptom_2) {
		Symptom_2 = symptom_2;
	}

	public long getSymptomId_2() {
		return SymptomId_2;
	}

	public void setSymptomId_2(long symptomId_2) {
		if(symptomId_2 != -1 && (getSymptom_2() == null || "".equals(getSymptom_2())))
    	{
    		setSymptom_2(getIncidenceObject("Symptom", symptomId_2).getAttributeName());
    	}
		SymptomId_2 = symptomId_2;
	}

	public String getSymptom_3() {
		return Symptom_3;
	}

	public void setSymptom_3(String symptom_3) {
		Symptom_3 = symptom_3;
	}

	public long getSymptomId_3() {
		return SymptomId_3;
	}

	public void setSymptomId_3(long symptomId_3) {
		if(symptomId_3 != -1 && (getSymptom_3() == null || "".equals(getSymptom_3())))
    	{
    		setSymptom_3(getIncidenceObject("Symptom", symptomId_3).getAttributeName());
    	}
		SymptomId_3 = symptomId_3;
	}

	public String getSymptom_4() {
		return Symptom_4;
	}

	public void setSymptom_4(String symptom_4) {
		Symptom_4 = symptom_4;
	}

	public long getSymptomId_4() {
		return SymptomId_4;
	}

	public void setSymptomId_4(long symptomId_4) {
		if(symptomId_4 != -1 && (getSymptom_4() == null || "".equals(getSymptom_4())))
    	{
    		setSymptom_4(getIncidenceObject("Symptom", symptomId_4).getAttributeName());
    	}
		SymptomId_4 = symptomId_4;
	}

	public String getSymptom_5() {
		return Symptom_5;
	}

	public void setSymptom_5(String symptom_5) {
		Symptom_5 = symptom_5;
	}

	public long getSymptomId_5() {
		return SymptomId_5;
	}

	public void setSymptomId_5(long symptomId_5) {
		if(symptomId_5 != -1 && (getSymptom_5() == null || "".equals(getSymptom_5())))
    	{
    		setSymptom_5(getIncidenceObject("Symptom", symptomId_5).getAttributeName());
    	}
		SymptomId_5 = symptomId_5;
	}

	public String getDiagnosis_1() {
        return Diagnosis_1;
    }

    public void setDiagnosis_1(String diagnosis_1) {
        Diagnosis_1 = diagnosis_1;
    }

    public long getDiagnosisId_1() {
        return DiagnosisId_1;
    }

    public void setDiagnosisId_1(long diagnosisId_1) {
    	if(diagnosisId_1 != -1 && (getDiagnosis_1() == null || "".equals(getDiagnosis_1())))
    	{
    		setDiagnosis_1(getIncidenceObject("Diagnosis", diagnosisId_1).getAttributeName());
    	}
        DiagnosisId_1 = diagnosisId_1;
    }

    public String getDiagnosis_2() {
        return Diagnosis_2;
    }

    public void setDiagnosis_2(String diagnosis_2) {
        Diagnosis_2 = diagnosis_2;
    }

    public long getDiagnosisId_2() {
        return DiagnosisId_2;
    }

    public void setDiagnosisId_2(long diagnosisId_2) {
    	if(diagnosisId_2 != -1 && (getDiagnosis_2() == null || "".equals(getDiagnosis_2())))
    	{
    		setDiagnosis_2(getIncidenceObject("Diagnosis", diagnosisId_2).getAttributeName());
    	}
        DiagnosisId_2 = diagnosisId_2;
    }

    public String getDiagnosis_3() {
        return Diagnosis_3;
    }

    public void setDiagnosis_3(String diagnosis_3) {
        Diagnosis_3 = diagnosis_3;
    }

    public long getDiagnosisId_3() {
        return DiagnosisId_3;
    }

    public void setDiagnosisId_3(long diagnosisId_3) {
    	if(diagnosisId_3 != -1 && (getDiagnosis_3() == null || "".equals(getDiagnosis_3())))
    	{
    		setDiagnosis_3(getIncidenceObject("Diagnosis", diagnosisId_3).getAttributeName());
    	}
        DiagnosisId_3 = diagnosisId_3;
    }

    public String getDiagnosis_4() {
        return Diagnosis_4;
    }

    public void setDiagnosis_4(String diagnosis_4) {
        Diagnosis_4 = diagnosis_4;
    }

    public long getDiagnosisId_4() {
        return DiagnosisId_4;
    }

    public void setDiagnosisId_4(long diagnosisId_4) {
    	if(diagnosisId_4 != -1 && (getDiagnosis_4() == null || "".equals(getDiagnosis_4())))
    	{
    		setDiagnosis_4(getIncidenceObject("Diagnosis", diagnosisId_4).getAttributeName());
    	}
        DiagnosisId_4 = diagnosisId_4;
    }

    public String getDiagnosis_5() {
        return Diagnosis_5;
    }

    public void setDiagnosis_5(String diagnosis_5) {
        Diagnosis_5 = diagnosis_5;
    }

    public long getDiagnosisId_5() {
        return DiagnosisId_5;
    }

    public void setDiagnosisId_5(long diagnosisId_5) {
    	if(diagnosisId_5 != -1 && (getDiagnosis_5() == null || "".equals(getDiagnosis_5())))
    	{
    		setDiagnosis_5(getIncidenceObject("Diagnosis", diagnosisId_5).getAttributeName());
    	}
        DiagnosisId_5 = diagnosisId_5;
    }

    public Date getIncidenceDate() {
        return IncidenceDate;
    }

    public void setIncidenceDate(Date incidenceDate) {
        IncidenceDate = incidenceDate;
    }
    
    public String getTemperature() {
		return Temperature;
	}

	public void setTemperature(String temperature) {
		Temperature = temperature;
	}

	public String getBloodPressure() {
		return BloodPressure;
	}

	public void setBloodPressure(String bloodPressure) {
		BloodPressure = bloodPressure;
	}

	public String getWeight() {
		return Weight;
	}

	public void setWeight(String weight) {
		Weight = weight;
	}

	public String getHeight() {
		return Height;
	}

	public void setHeight(String height) {
		Height = height;
	}

	public String getSince_1() {
		return since_1;
	}

	public void setSince_1(String since_1) {
		this.since_1 = since_1;
	}

	public String getSince_2() {
		return since_2;
	}

	public void setSince_2(String since_2) {
		this.since_2 = since_2;
	}

	public String getSince_3() {
		return since_3;
	}

	public void setSince_3(String since_3) {
		this.since_3 = since_3;
	}

	public String getSince_4() {
		return since_4;
	}

	public void setSince_4(String since_4) {
		this.since_4 = since_4;
	}

	public String getSince_5() {
		return since_5;
	}

	public void setSince_5(String since_5) {
		this.since_5 = since_5;
	}
	
	public Date getAppointmentDate() {
		return AppointmentDate;
	}

	public void setAppointmentDate(Date appointmentDate) {
		AppointmentDate = appointmentDate;
	}
	
	public String getMedication_1() {
		return Medication_1;
	}

	public void setMedication_1(String medication_1) {
		Medication_1 = medication_1;
	}

	public long getMedicationId_1() {
		return MedicationId_1;
	}

	public void setMedicationId_1(long medicationId_1) {
		MedicationId_1 = medicationId_1;
	}

	public String getMedication_2() {
		return Medication_2;
	}

	public void setMedication_2(String medication_2) {
		Medication_2 = medication_2;
	}

	public long getMedicationId_2() {
		return MedicationId_2;
	}

	public void setMedicationId_2(long medicationId_2) {
		MedicationId_2 = medicationId_2;
	}

	public String getTimeId_1()
	{
		return TimeId_1;
	}

	public void setTimeId_1(String TimeId_1)
	{
		this.TimeId_1 = TimeId_1;
	}

	
	public String getTimeId_2()
	{
		return TimeId_2;
	}

	public void setTimeId_2(String TimeId_2)
	{
		this.TimeId_2 = TimeId_2;
	}

	public String getComment() {
		return Comment;
	}

	public void setComment(String comment) {
		Comment = comment;
	}

	@Override
    public String toString() {
        return "Incidence{" +
                "Id=" + Id +
                ", PatientId=" + UserId +
                ", Patient=" + User +
                ", FirstName='" + FirstName + '\'' +
                ", LastName='" + LastName + '\'' +
                ", MiddleName='" + MiddleName + '\'' +
                ", Problem_1='" + Problem_1 + '\'' +
                ", ProblemId_1=" + ProblemId_1 +
                ", Problem_2='" + Problem_2 + '\'' +
                ", ProblemId_2=" + ProblemId_2 +
                ", Problem_3='" + Problem_3 + '\'' +
                ", ProblemId_3=" + ProblemId_3 +
                ", Problem_4='" + Problem_4 + '\'' +
                ", ProblemId_4=" + ProblemId_4 +
                ", Problem_5='" + Problem_5 + '\'' +
                ", ProblemId_5=" + ProblemId_5 +
                ", Diagnosis_1='" + Diagnosis_1 + '\'' +
                ", DiagnosisId_1=" + DiagnosisId_1 +
                ", Diagnosis_2='" + Diagnosis_2 + '\'' +
                ", DiagnosisId_2=" + DiagnosisId_2 +
                ", Diagnosis_3='" + Diagnosis_3 + '\'' +
                ", DiagnosisId_3=" + DiagnosisId_3 +
                ", Diagnosis_4='" + Diagnosis_4 + '\'' +
                ", DiagnosisId_4=" + DiagnosisId_4 +
                ", Diagnosis_5='" + Diagnosis_5 + '\'' +
                ", DiagnosisId_5=" + DiagnosisId_5 +
                ", IncidenceDate=" + IncidenceDate +
                '}';
    }
}
