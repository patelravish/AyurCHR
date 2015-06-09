package fv.ayurchr.dbobjects.hibernate;

public class Symptom {
    private long Id = -1;
    private String Description = "";
    private long ProblemId = 1;
    private User Problem;
    public static String ENTITY = "SYMPTOM";

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

    public long getProblemId() {
		return ProblemId;
	}

	public void setProblemId(long problemId) {
		ProblemId = problemId;
	}

	public User getProblem() {
		return Problem;
	}

	public void setProblem(User problem) {
		Problem = problem;
	}

	@Override
    public String toString() {
        return "fv.ayurchr.dbobjects.hibernate.Symptom{" +
                "Id=" + Id +
                ", Description='" + Description + '\'' +
                '}';
    }
}
