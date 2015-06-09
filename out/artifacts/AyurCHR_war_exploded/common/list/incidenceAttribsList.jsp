<%@page import="java.text.SimpleDateFormat"%>
<%@page import="fv.ayurchr.dbobjects.hibernate.Incidence"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.TreeMap"%>
<%@page import="fv.ayurchr.commons.security.util.Constants"%>
<%@page import="fv.ayurchr.dbobjects.hibernate.IncidenceAttribsView"%>
<%@page import="net.sf.json.JSONArray"%>
<%@page import="net.sf.json.JSONObject"%>
<%@page import="fv.ayurchr.dbobjects.hibernate.Symptom"%>
<%@page import="fv.ayurchr.dbobjects.hibernate.Problem"%>
<%@page import="java.util.List" %>
<%@page import="fv.ayurchr.commons.HibernateSession" %>

<%
    HibernateSession hs = new HibernateSession();

	String incidenceId = request.getParameter("IncidenceId");
    List<IncidenceAttribsView> probList = hs.getList("INCIDENCEATTRIBSVIEW", "attributeType", "Finding");
    JSONArray problemArr = new JSONArray();
    JSONObject obj = new JSONObject();
    
    SimpleDateFormat sdf = new SimpleDateFormat(Constants.INCIDENCE_DATE_FORMAT);
    Incidence editIncidenceObj = null;
    if(incidenceId != null && !"".equals(incidenceId) && !"null".equals(incidenceId))
    {
    	editIncidenceObj = (Incidence)hs.getEntity("INCIDENCE", Long.parseLong(incidenceId));
    	obj.put("NEXT_VISIT", editIncidenceObj.getAppointmentDate() != null ? sdf.format(editIncidenceObj.getAppointmentDate()) : "");
    	obj.put("TEMPERATURE", editIncidenceObj.getTemperature());
    	obj.put("BLOOD_PRESSURE", editIncidenceObj.getBloodPressure());
    	obj.put("WEIGHT", editIncidenceObj.getWeight());
    	obj.put("HEIGHT", editIncidenceObj.getHeight());
    	obj.put("COMMENT", editIncidenceObj.getComment());
    	
    	// check if the time difference incidence was created and the current time is  > 8 hours then show the form as disabled
    	if(System.currentTimeMillis() - editIncidenceObj.getIncidenceDate().getTime() > Constants.INCIDENCE_ALLOW_EDIT_UPTO_HRS*60*60*1000)
    	{
    		obj.put("DISABLED", "Y");
    	}
    }
    
    JSONObject problemObj = new JSONObject();
    problemObj.put("name", "");
    problemObj.put("id", "-1");
	problemArr.add(problemObj);
    for(IncidenceAttribsView problem : probList)
    {
    	problemObj = new JSONObject();
    	problemObj.put("name", problem.getAttributeDesc());
    	problemObj.put("id", problem.getId());
    	problemArr.add(problemObj);
    }
    obj.put("PROBLEM", problemArr);
    if(editIncidenceObj != null)
    {
	    obj.put("PROBLEM_1_VALUE", editIncidenceObj.getProblemId_1());
	    obj.put("PROBLEM_2_VALUE", editIncidenceObj.getProblemId_2());
	    obj.put("PROBLEM_3_VALUE", editIncidenceObj.getProblemId_3());
	    obj.put("PROBLEM_4_VALUE", editIncidenceObj.getProblemId_4());
	    obj.put("PROBLEM_5_VALUE", editIncidenceObj.getProblemId_5());
    }
    
    List<IncidenceAttribsView> symptList = hs.getList("INCIDENCEATTRIBSVIEW", "attributeType", "Symptom");
    JSONArray symptomArr = new JSONArray();
    JSONObject symptomObj = new JSONObject();
    symptomObj.put("name", "");
    symptomObj.put("id", "-1");
	symptomArr.add(symptomObj);
    for(IncidenceAttribsView symptom : symptList)
    {
    	symptomObj = new JSONObject();
    	symptomObj.put("name", symptom.getAttributeName());
    	symptomObj.put("id", symptom.getId());
    	symptomArr.add(symptomObj);
    }
    obj.put("SYMPTOM", symptomArr);
    if(editIncidenceObj != null)
    {
	    obj.put("SYMPTOM_1_VALUE", editIncidenceObj.getSymptomId_1());
	    obj.put("SYMPTOM_2_VALUE", editIncidenceObj.getSymptomId_2());
	    obj.put("SYMPTOM_3_VALUE", editIncidenceObj.getSymptomId_3());
	    obj.put("SYMPTOM_4_VALUE", editIncidenceObj.getSymptomId_4());
	    obj.put("SYMPTOM_5_VALUE", editIncidenceObj.getSymptomId_5());
    }
    
    List<IncidenceAttribsView> diagnosisList = hs.getList("INCIDENCEATTRIBSVIEW", "attributeType", "Diagnosis");
    JSONArray diagnosisArr = new JSONArray();
    JSONObject diagnosisObj = new JSONObject();
    diagnosisObj.put("name", "");
    diagnosisObj.put("id", "-1");
    diagnosisArr.add(symptomObj);
    for(IncidenceAttribsView diagnosis : diagnosisList)
    {
    	diagnosisObj = new JSONObject();
    	diagnosisObj.put("name", diagnosis.getAttributeName());
    	diagnosisObj.put("id", diagnosis.getId());
    	diagnosisArr.add(diagnosisObj);
    }
    obj.put("DIAGNOSIS", diagnosisArr);
    if(editIncidenceObj != null)
    {
    	obj.put("DIAGNOSIS_1_VALUE", editIncidenceObj.getDiagnosisId_1());
	    obj.put("DIAGNOSIS_2_VALUE", editIncidenceObj.getDiagnosisId_2());
	    obj.put("DIAGNOSIS_3_VALUE", editIncidenceObj.getDiagnosisId_3());
	    obj.put("DIAGNOSIS_4_VALUE", editIncidenceObj.getDiagnosisId_4());
	    obj.put("DIAGNOSIS_5_VALUE", editIncidenceObj.getDiagnosisId_5());
    }
    
    JSONArray sinceArr = new JSONArray();
    JSONObject sinceObj = new JSONObject();
    sinceObj.put("name", "");
    sinceObj.put("id", "-1");
    sinceArr.add(sinceObj);
    TreeMap<Float, String> sortedMap = new TreeMap<Float, String>(Constants.SINCE_VALUES_MAP);
    Set<Float> set = sortedMap.keySet();
    for(Float sinceKey : set)
    {
    	sinceObj = new JSONObject();
    	sinceObj.put("name", Constants.SINCE_VALUES_MAP.get(sinceKey));
    	sinceObj.put("id", sinceKey.toString());
    	sinceArr.add(sinceObj);
    }
    obj.put("SINCE", sinceArr);
    if(editIncidenceObj != null)
    {
	    obj.put("SINCE_1_VALUE", editIncidenceObj.getSince_1());
	    obj.put("SINCE_2_VALUE", editIncidenceObj.getSince_2());
	    obj.put("SINCE_3_VALUE", editIncidenceObj.getSince_3());
	    obj.put("SINCE_4_VALUE", editIncidenceObj.getSince_4());
	    obj.put("SINCE_5_VALUE", editIncidenceObj.getSince_5());
    }
    
    JSONArray medicationArr = new JSONArray();
    JSONObject medicationObj = new JSONObject();
    medicationObj.put("name", "");
    medicationObj.put("id", "-1");
    medicationArr.add(medicationObj);
    TreeMap<String, String> sortedMedicationMap = new TreeMap<String, String>(Constants.MEDICATION_VALUES_MAP);
    Set<String> medicationSet = sortedMedicationMap.keySet();
    for(String medicationKey : medicationSet)
    {
    	medicationObj = new JSONObject();
    	medicationObj.put("name", Constants.MEDICATION_VALUES_MAP.get(medicationKey));
    	medicationObj.put("id", medicationKey.toString());
    	medicationArr.add(medicationObj);
    }
    obj.put("MEDICATION", medicationArr);
    if(editIncidenceObj != null)
    {
	    obj.put("MEDICATION_1_VALUE", editIncidenceObj.getMedicationId_1());
	    obj.put("MEDICATION_2_VALUE", editIncidenceObj.getMedicationId_2());
    }
    
    JSONArray timeArr = new JSONArray();
    JSONObject timeObj = new JSONObject();
    timeObj.put("name", "");
    timeObj.put("id", "-1");
    timeArr.add(timeObj);
    TreeMap<String, String> sortedTimeMap = new TreeMap<String, String>(Constants.TAKEATTIME_VALUES_MAP);
    Set<String> timeSet = sortedTimeMap.keySet();
    for(String timeKey : timeSet)
    {
    	timeObj = new JSONObject();
    	timeObj.put("name", Constants.TAKEATTIME_VALUES_MAP.get(timeKey));
    	timeObj.put("id", timeKey.toString());
    	timeArr.add(timeObj);
    }
    obj.put("TAKEATTIME", timeArr);
    if(editIncidenceObj != null)
    {
	    obj.put("TIME_1_VALUE", editIncidenceObj.getTimeId_1());
	    obj.put("TIME_2_VALUE", editIncidenceObj.getTimeId_2());
    }
%>
<%=obj.toString()%>
