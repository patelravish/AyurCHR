package fv.ayurchr.dbobjects.hibernate;


public class IncidenceAttribsView {
    public static final String ENTITY = "INCIDENCEATTRIBSVIEW";
    private long Id = 1;
    private String attributeName = "";
    private String attributeDesc = "";
    private long dataTypeId = 1;
    private long classId = 1;
    private String classDesc = "";
    private String attributeType = "";
    
    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

	public String getAttributeName() {
		return attributeName;
	}

	public void setAttributeName(String attributeName) {
		this.attributeName = attributeName;
	}

	public String getAttributeDesc() {
		return attributeDesc;
	}

	public void setAttributeDesc(String attributeDesc) {
		this.attributeDesc = attributeDesc;
	}

	public long getDataTypeId() {
		return dataTypeId;
	}

	public void setDataTypeId(long dataTypeId) {
		this.dataTypeId = dataTypeId;
	}

	public long getClassId() {
		return classId;
	}

	public void setClassId(long classId) {
		this.classId = classId;
	}

	public String getClassDesc() {
		return classDesc;
	}

	public void setClassDesc(String classDesc) {
		this.classDesc = classDesc;
	}

	public String getAttributeType() {
		return attributeType;
	}

	public void setAttributeType(String attributeType) {
		this.attributeType = attributeType;
	}

}
